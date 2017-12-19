package test.service.mq.init.simple;

import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import com.google.common.collect.Maps;

public class Publisher {
	
	protected int MAX_DELTA_PERCENT = 1;
	protected Map<String, Double> LAST_PRICES = Maps.newHashMap();
	protected static int count = 10;
	protected static int total;
	
	protected static String brokerURL = "tcp://localhost:61616";
	// 连接工厂，JMS用它创建连接
	protected static transient ConnectionFactory factory;
	// JMS客户端到JMS Provider的连接
	protected transient Connection connection;
	// 一个发送或接收消息的线程
	protected transient Session session;
	// 消息发送者
	protected transient MessageProducer producer;
	
	public Publisher() throws JMSException{
		// 实例化连接工厂，采用ActiveMQ实现，
		factory = new ActiveMQConnectionFactory(brokerURL);
		// 创建JMS连接，由ActiveMQ实现
		connection = factory.createConnection();
		try {
			connection.start();
		} catch (JMSException e) {
			connection.close();
			e.printStackTrace();
			throw e;
		}
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		producer = session.createProducer(null);
		// 设置消息不持久化
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	}
	
	public void close() throws JMSException{
		if(connection != null){
			connection.close();
		}
	}
	
	public static void main(String[] args) throws JMSException {
		Publisher publisher = new Publisher();
		while(total < 100){
			for(int i=0; i<count; i++){
				publisher.sendMessage(args);
			}
			total += count;
			System.out.println("Published " + count + " of " + total + "prices messages");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		publisher.close();
	}
	
	protected void sendMessage(String[] stocks) throws JMSException {
		int idx = 0;
		while (true) {  
            idx = (int)Math.round(stocks.length * Math.random());  
            if (idx < stocks.length) {  
                break;  
            }  
        }  
        String stock = stocks[idx];  
        // 消息的目的地，发送到哪里
//        Destination destination = session.createTopic("STOCKS." + stock);  
        Destination destination = session.createQueue("QUEUE." + stock);  
        Message message = createStockMessage(stock, session);  
        System.out.println("Sending: " + ((ActiveMQMapMessage)message).getContentMap() + " on destination: " + destination);  
        producer.send(destination, message);  
	}
	
	protected Message createStockMessage(String stock, Session session) throws JMSException {  
        Double value = LAST_PRICES.get(stock);  
        if (value == null) {  
            value = new Double(Math.random() * 100);  
        }  
  
        // lets mutate the value by some percentage  
        double oldPrice = value.doubleValue();  
        value = new Double(mutatePrice(oldPrice));  
        LAST_PRICES.put(stock, value);  
        double price = value.doubleValue();  
  
        double offer = price * 1.001;  
  
        boolean up = (price > oldPrice);  
  
        MapMessage message = session.createMapMessage();  
        message.setString("stock", stock);  
        message.setDouble("price", price);  
        message.setDouble("offer", offer);  
        message.setBoolean("up", up);  
        return message;  
    }  
  
    protected double mutatePrice(double price) {  
        double percentChange = (2 * Math.random() * MAX_DELTA_PERCENT) - MAX_DELTA_PERCENT;  
  
        return price * (100 + percentChange) / 100;  
    }  

}
