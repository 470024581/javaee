package test.designPattern.structural.bridge;

/**
 *	桥接模式：将抽象部分与它的实现部分分离，使它们都可以独立的变化。
 *	适用性：1.你不希望在抽象和它的实现部分之间有一个固定的绑定关系。
 *		2.类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。
 *		3.对一个抽象的实现部分的修改应对客户端不产生影响，即客户的代码必须要重新编译。
 *	优点：将抽象化与实现化解耦，使得二者（有可能是更多维度）可独立变化，强关联变弱关联，由继承关系变组合关系。
 **/
public class Client {

	public static void main(String[] args) {
		ICar bus = new Bus();
		People man = new Man(bus);
		man.run();//男人开公交车
	}

}
