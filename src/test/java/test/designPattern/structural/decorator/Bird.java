package test.designPattern.structural.decorator;

/**
 *	具体实现Decorator的装饰者，向组件添加职能 
 **/
public class Bird extends Decorator {

	public Bird(Component component) {
		super(component);
	}
	
	public void run() {
		System.out.println("bird fly...");
	}
	
}
