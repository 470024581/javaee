package test.designPattern.structural.decorator;

/**
 *	ά��һ��ָ��Component��������ã���һ��һ����Componentһ�µĽӿ�
 **/
public class Decorator implements Component {
	
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}

	@Override
	public void run() {
		component.run();
	}

}
