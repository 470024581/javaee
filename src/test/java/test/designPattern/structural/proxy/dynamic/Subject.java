package test.designPattern.structural.proxy.dynamic;

public class Subject implements ISubject {

	@Override
	public void run() {
		System.out.println("running....");
	}

	@Override
	public void stop() {
		System.out.println("stop...");
	}

}
