package test.designPattern.structural.bridge;

public class Women extends People {

	public Women(ICar iCar) {
		super(iCar);
	}

	@Override
	void run() {
		System.out.print("Å®ÈË¿ª");
		iCar.run();
	}

}
