package test.designPattern.creational.factory.simple;

/**
 * �򵥹������ʺ�һ�����ͣ��������ࣩ
 * �ŵ㣺ֻҪʵ�ֹ��еĽӿھͿ���ʵ�ֲ�ͬ���ܵķ�ʽ
 * ȱ�㣺Ҫ�ж������ֳ�����Ҫ��CarFactory��
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
