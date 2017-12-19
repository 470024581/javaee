package test.framework.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class Message3 extends BaseMessage {

	// �����ж����������������ִ��
	@Subscribe
	public void printMessage(Person3 person) {
		try {
			super.rl.acquire();
			System.out.println(this.getClass().getName() + "===" + person.getId() + "===" + person.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Subscribe
	public void printMessage2(Person1 person) {
		try {
			super.rl.acquire();
			System.out.println(this.getClass().getName() + "===" + person.getId() + "===" + person.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
