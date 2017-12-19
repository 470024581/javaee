package test.designPattern.structural.decorator;

/**
 *	����ʵ��Decorator��װ���ߣ���������ְ�� 
 **/
public class Bird extends Decorator {

	public Bird(Component component) {
		super(component);
	}
	
	public void run() {
		System.out.println("bird fly...");
	}
	
}
