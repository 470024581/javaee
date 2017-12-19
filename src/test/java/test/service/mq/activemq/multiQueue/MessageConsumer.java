package test.service.mq.activemq.multiQueue;

/**
 * 消费者：可以配置多线程消费消息
 * @author lliang
 *
 */
public class MessageConsumer {
	
	public void receive(Product product){
		System.out.println("server接收的消息：" + product.getId() + product.getName());
	}

}
