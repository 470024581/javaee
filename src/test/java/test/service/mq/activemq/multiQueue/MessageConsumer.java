package test.service.mq.activemq.multiQueue;

/**
 * �����ߣ��������ö��߳�������Ϣ
 * @author lliang
 *
 */
public class MessageConsumer {
	
	public void receive(Product product){
		System.out.println("server���յ���Ϣ��" + product.getId() + product.getName());
	}

}
