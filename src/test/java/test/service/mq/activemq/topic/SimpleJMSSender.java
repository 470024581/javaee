package test.service.mq.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "sender.xml" })  
public class SimpleJMSSender {  
  
    @Autowired
	private JmsTemplate jmsTemplate;
    
    @Test
    public void test(){
    	try {
    		for (int i = 0; i < 10; i++) {  
                jmsTemplate.send(new MessageCreator() {  
                    public Message createMessage(Session session) throws JMSException {  
                        TextMessage msg = session.createTextMessage();  
                        // ������Ϣ����  
                        msg.setStringProperty("phrCode", "C001");  
                        // ������Ϣ����  
                        msg.setText("Hello World!"+System.currentTimeMillis());  
                        return msg;  
                    }  
                });  
            }  
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}  
