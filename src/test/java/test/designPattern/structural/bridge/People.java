package test.designPattern.structural.bridge;

public abstract class People {
	
	ICar iCar; 
	public People(ICar iCar){
		this.iCar = iCar;
	}
	abstract void run();

}
