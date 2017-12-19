package test.designPattern.behavior.memento;

/**
 *	对进行备份的Memento进行存储，在需要的时候调用此类的memento对象引用 
 **/
public class Caretaker {
	
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}

}
