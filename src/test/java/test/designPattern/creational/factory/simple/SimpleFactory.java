package test.designPattern.creational.factory.simple;

/**
 * 简单工厂：适合一个类型（如汽车类）
 * 优点：只要实现共有的接口就可以实现不同车跑的方式
 * 缺点：要判断是哪种车，需要改CarFactory类
 **/
public class SimpleFactory{
	public static void main(String[] arg){
		ICar aCar = CarFactory.getCar("ACar");
		aCar.run();
	}
}
interface ICar {
	public void run();
}
class ACar implements ICar{ 
	public void run(){ 
		System.out.println("ACar is running!"); 
	} 
}
class BCar implements ICar{
	public void run(){ 
		System.out.println("BCar is running!"); 
	} 
}
class CarFactory{
	public static ICar getCar(String carType){
		if("ACar".equals(carType)){
			return new ACar();
		} else if("BCar".equals(carType)){
			return new BCar();
		}
		return null;
	}
}
