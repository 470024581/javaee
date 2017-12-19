package test.designPattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	
	private List<Observer> list = new ArrayList<Observer>();

	@Override
	public void addSubject(Observer observer) {
		list.add(observer);
	}

	@Override
	public void removeSubject(Observer observer) {
		list.remove(observer);
	}

	@Override
	public void notifySubjects(String str) {
		// 自动调用实际上是目标（subject）进行调用的
		for(Observer observer : list){
			observer.update(str);
		}
	}

}
