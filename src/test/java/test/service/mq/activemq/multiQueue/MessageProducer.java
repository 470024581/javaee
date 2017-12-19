package test.service.mq.activemq.multiQueue;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

public class MessageProducer {

    private ActiveMQQueue destination;

    private List<JmsTemplate> jmsTemplate;

    //原子整型计数（CAS），可以不使用同步
    private AtomicInteger current = new AtomicInteger(0);

    //轮询算法解决负载均衡
    private JmsTemplate findJmsTemplate(){
        int cur = current.getAndIncrement();
        int index = cur%jmsTemplate.size();
        System.out.println("负载均衡：生产者"+current+"   模版："+jmsTemplate.get(index).toString());
        return jmsTemplate.get(index);
    }
    
    //发送消息
    public void sendMessage(Product product){
        this.findJmsTemplate().convertAndSend(destination, product);
    }

    public ActiveMQQueue getDestination() {
        return destination;
    }

    public void setDestination(ActiveMQQueue destination) {
        this.destination = destination;
    }

    public List<JmsTemplate> getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(List<JmsTemplate> jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

  }
