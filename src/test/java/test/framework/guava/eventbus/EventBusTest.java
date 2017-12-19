package test.framework.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusTest {

	public static void main(String[] args) {
		try {
			// �¼�����
			EventBus eventBus = new EventBus();
			// ע���Ӧ��Ҫ�������¼�
			eventBus.register(new Message1());
			eventBus.register(new Message2());
			eventBus.register(new Message3());
			Person1 p = new Person1("id", "name");
			// �����¼�
			eventBus.post(p);
			Person3 p3 = new Person3("id3", "name3");
			eventBus.post(p3);
			eventBus.post(p3);
			
			eventBus.post(p3);
			eventBus.unregister(new Message3());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
