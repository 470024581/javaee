package test.designPattern.behavior.memento;

public class Client {

	public static void main(String[] args) {
		Originator o = new Originator();
		o.setState("正在睡觉中。。。。。。");
		Caretaker ca = new Caretaker();
		ca.setMemento(o.createMemento());
		o.setState("正在学习中。。。。。。");
		o.showState();
		o.useMemento(ca.getMemento());
		o.showState();
	}

}
