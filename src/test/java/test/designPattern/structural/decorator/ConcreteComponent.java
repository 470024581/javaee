package test.designPattern.structural.decorator;

/**
 *	定义一个对象，可以给这个对象添加一些职能 
 **/
public class ConcreteComponent implements Component {

	@Override
	public void run() {
		System.out.println("run...");
	}

}
