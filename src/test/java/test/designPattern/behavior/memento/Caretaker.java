package test.designPattern.behavior.memento;

/**
 *	�Խ��б��ݵ�Memento���д洢������Ҫ��ʱ����ô����memento�������� 
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
