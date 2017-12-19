package test.designPattern.behavior.memento;

public class Client {

	public static void main(String[] args) {
		Originator o = new Originator();
		o.setState("����˯���С�����������");
		Caretaker ca = new Caretaker();
		ca.setMemento(o.createMemento());
		o.setState("����ѧϰ�С�����������");
		o.showState();
		o.useMemento(ca.getMemento());
		o.showState();
	}

}
