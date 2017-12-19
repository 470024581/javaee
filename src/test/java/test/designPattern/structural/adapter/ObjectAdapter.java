package test.designPattern.structural.adapter;

/**
 * 	适配器模式：将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 	对象适配器：通过对象的委派，实现目标接口的API，推荐使用这种方式（解耦）
 * 	适用性：1.你想使用一个已经存在的类，而它的接口不符合你的需求
 *		2.你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类协同工作
 *		3.（仅适用于对象Adapter）你想使用一些已经存在的子类，但不可能对每个都进行子类化以匹配他们的接口。对象适配器可以适配它的父类接口。
 *	优点：更好的复用，更好的扩展
 *	缺点：过多的适配器，会让系统凌乱，不利于整体把控，如果不是很有必要，可以不使用，而是重构系统
 **/
public class ObjectAdapter {
	private Adapter adapter;
	public ObjectAdapter(Adapter adaptee){ 
		this.adapter = adaptee; 
	}
	public void sampleOperation1(){
		this.adapter.sampleOperation1();
	}
	public void sampleOperation2(){ 
		//相关代码 
	}
}
