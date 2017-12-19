package test.framework.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class Message1 extends BaseMessage {
	
	
	// 事件监听的方法
	@Subscribe
	public synchronized void printMessage(Person1 person) {
		try {
			super.rl.acquire();
			System.out.println(this.getClass().getName() + "===" + person.getId() + "===" + person.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
