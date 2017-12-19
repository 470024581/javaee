package test.designPattern.creational.factory.method;


/**
 *	工厂方法：适合多个类型，如奔驰，宝马，把共有的东西抽象出来
 *		（一个抽象产品类，派生多个具体产品类，一个抽象工厂类，派生多个具体工厂类，每个具体工厂类只创建一个具体产品）
 *	优点：符合了开放-封闭原则（OCP：open closed principle开放扩展，封闭修改）
 * 	缺点：有多少产品就需要有多少个具体工厂类
 **/
public class MethodFactory {
	public static void main(String[] arg){
		CarFactory aCarFactory = new ACarFactory();
		ICar aCar = aCarFactory.getCar();
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
abstract class CarFactory{
	public abstract ICar getCar();
}
class ACarFactory extends CarFactory{
	public ICar getCar(){
		return new ACar();
	}
}

class BCarFactory extends CarFactory{
	public ICar getCar(){
		return new BCar();
	}
}

