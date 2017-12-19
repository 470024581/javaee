package test.designPattern.behavior.observer;

/**
 * 可以通过继承java.util.Observable
 **/
public class Client {

	public static void main(String[] args) {
		Subject girl = new ConcreteSubject();
		
		Observer observer1 = new ConcreteObserver();
		Observer observer2 = new ConcreteObserver();
		Observer observer3 = new ConcreteObserver();
		
		girl.addSubject(observer1);
		girl.addSubject(observer2);
		girl.addSubject(observer3);
		
		girl.notifySubjects("开心！");
		
	}

}
