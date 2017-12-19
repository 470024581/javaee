package test.service.mq.activemq.queue;

  
import java.util.Random;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
  
/**
 * Ҫ���������ص�activemq����
 * @author lliang
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration(locations = { "active-mq.xml" })  
public class RunTest {  
	
//	@Autowired
	private JmsTemplate jmsTemplate;
	
//	@Test
	public void test(){
//		int i = 0;
//		while(i < 5){
//			i++;
//			send();
//		}
	}
	
	public void send(){
		jmsTemplate.send("demo1", new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSON.toJSONString(new Foo(new Random().nextInt(),"foo")));
			}
		});
	}
	
	
}   
