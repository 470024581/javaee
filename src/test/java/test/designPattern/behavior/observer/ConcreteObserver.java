package test.designPattern.behavior.observer;

public class ConcreteObserver implements Observer {

	@Override
	public void update(String str) {
		System.out.println(str);
	}

}
