package test.service.mq.activemq.multiQueue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Ҫ���������ص�activemq����
 * 
 * ���߳���Ѷ������ߵ���Ϣ
 * @author lliang
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)  
//@ContextConfiguration(locations = { "active-mq.xml" })  
public class RunTest {
	
//	@Autowired
	private MessageProducer queueProducer;
	
//	@Test
	public void test(){
		try {
			int i = 0;
//			while(true){
//				Product product = new Product();
//				product.setId(i);
//				product.setName("С��");
//				queueProducer.sendMessage(product);
//				i++;
//				Thread.sleep(1000);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
