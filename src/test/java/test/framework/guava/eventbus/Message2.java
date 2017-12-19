package test.framework.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class Message2 extends BaseMessage {
	
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
