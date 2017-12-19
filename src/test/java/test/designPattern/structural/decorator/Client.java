package test.designPattern.structural.decorator;

/**
 * 装饰者模式：动态的给一个对象添加一些额外的职责。比生成子类更灵活。
 * 适用性：1在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职能
 * 		2处理哪些可以撤销的职能
 * 		3当不能采用生成子类的方法进行扩展时
 * 存在了2层的实现和继承关系，给组件类
 **/
public class Client {

	public static void main(String[] args) {
		Component com = new ConcreteComponent();
		Component fish = new Fish(com);
		Component bird = new Bird(fish);
		bird.run();//bird fly…
		fish.run();//run...
	}
	
}
