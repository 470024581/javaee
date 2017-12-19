package test.designPattern.structural.decorator;

/**
 *	维持一个指向Component对象的引用，并一定一个与Component一致的接口
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
