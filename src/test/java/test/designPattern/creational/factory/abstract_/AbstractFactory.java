package test.designPattern.creational.factory.abstract_;

/**
 *	���󹤳����ʺ϶�����͵Ľ�ϣ�����Ʒ�ƣ��������ͣ������˶������ã���
 *		����������Ʒ�࣬������������Ʒ�࣬һ�����󹤳��࣬����������幤���࣬ÿ�����幤������Դ�����������Ʒ���ʵ����
 **/
public class AbstractFactory {
	public static void main(String[] arg){
		IFactory factory = new AFactory();
		ISportCar aSportCar = factory.getSportCar();
		aSportCar.run();
	}
}
interface IBusinessCar{ 
	void run(); 
}
interface ISportCar{ 
	void run(); 
}
class ABusinessCar implements IBusinessCar{ 
	public void run(){ 
		System.out.println("ABusinessCar is running!"); 
	} 
} 
class BBusinessCar implements IBusinessCar{ 
	public void run(){ 
		System.out.println("BBusinessCar is running!"); 
	} 
}
class ASportCar implements ISportCar{ 
	public void run(){ 
		System.out.println("ASportCar is running!"); 
	} 
}
class BSportCar implements ISportCar{ 
	public void run(){ 
		System.out.println("BSportCar is running!"); 
	} 
}
interface IFactory{
	IBusinessCar getBusinessCar();
	ISportCar getSportCar();
}
class AFactory implements IFactory{
	public IBusinessCar getBusinessCar(){ 
		return new ABusinessCar(); 
	}
	public ISportCar getSportCar(){ 
		return new ASportCar(); 
	}
}
class BFactory implements IFactory{
	public IBusinessCar getBusinessCar(){ 
		return new BBusinessCar(); 
	}
	public ISportCar getSportCar(){ 
		return new BSportCar(); 
	}
}

