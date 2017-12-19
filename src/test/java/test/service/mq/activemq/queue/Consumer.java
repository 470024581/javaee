package test.service.mq.activemq.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@SuppressWarnings("rawtypes")
@Component("customerListener")
public class Consumer implements SessionAwareMessageListener {
	
	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	int i = 0;
	
	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		logger.info("consumer receiver message");
		//设计异常看是否重试
		while(true){
			i++;
//			if(i == 1){
//				throw new JMSException("故意报错!");
//			}
			if(message instanceof TextMessage){
				logger.info("正常");
				TextMessage tmsg = (TextMessage)message;
				String jsonString = tmsg.getText();
				logger.info("========receiver data string:"+jsonString);
				//json转换成obj
				Foo foo = JSON.parseObject(jsonString,Foo.class);
				logger.info("========receiver data class:"+foo);
				Object obj = JSON.parse(jsonString);
				logger.info("========receiver data obj:"+obj);
				break;
			}
		}
	}

}
