package test.designPattern.creational.factory.method;


/**
 *	�����������ʺ϶�����ͣ��籼�ۣ������ѹ��еĶ����������
 *		��һ�������Ʒ�࣬������������Ʒ�࣬һ�����󹤳��࣬����������幤���࣬ÿ�����幤����ֻ����һ�������Ʒ��
 *	�ŵ㣺�����˿���-���ԭ��OCP��open closed principle������չ������޸ģ�
 * 	ȱ�㣺�ж��ٲ�Ʒ����Ҫ�ж��ٸ����幤����
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

