package test.designPattern.creational.factory.abstract_;

/**
 *	抽象工厂：适合多个类型的结合，汽车品牌，汽车类型（商务，运动，家用），
 *		（多个抽象产品类，派生多个具体产品类，一个抽象工厂类，派生多个具体工厂类，每个具体工厂类可以创建多个具体产品类的实例）
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

