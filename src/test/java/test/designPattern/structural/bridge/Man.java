package test.designPattern.structural.bridge;

public class Man extends People {

	public Man(ICar iCar) {
		super(iCar);
	}

	@Override
	void run() {
		System.out.print("ÄĞÈË¿ª");
		iCar.run();
	}

}
