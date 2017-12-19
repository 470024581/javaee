package test.service.mq.activemq.topic;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "receiverTwo.xml" })  
public class SimpleJMSReceiverTwo {  
	  
    @Test
    public void test(){
    	while(true) {  
    		
        }  
    }
      
    public void receive(TextMessage message) throws JMSException {  
        System.out.println(message.getStringProperty("phrCode"));  
        System.out.println(message.getText());  
    }  
}  
