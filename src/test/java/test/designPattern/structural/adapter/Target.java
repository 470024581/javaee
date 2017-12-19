package test.designPattern.structural.adapter;

public interface Target {
	//sample：样品，榜样
	//源类Adaptee也有的方法
	public void sampleOperation1();
	
	//源类Adaptee没有的方法
	public void sampleOperation2();
}
