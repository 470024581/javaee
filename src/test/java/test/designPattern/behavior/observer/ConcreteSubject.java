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
		// �Զ�����ʵ������Ŀ�꣨subject�����е��õ�
		for(Observer observer : list){
			observer.update(str);
		}
	}

}
