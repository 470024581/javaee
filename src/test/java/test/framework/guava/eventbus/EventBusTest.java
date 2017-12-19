package test.framework.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusTest {

	public static void main(String[] args) {
		try {
			// 事件总线
			EventBus eventBus = new EventBus();
			// 注册对应需要监听的事件
			eventBus.register(new Message1());
			eventBus.register(new Message2());
			eventBus.register(new Message3());
			Person1 p = new Person1("id", "name");
			// 发送事件
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
