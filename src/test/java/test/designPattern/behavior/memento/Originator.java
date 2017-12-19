package test.designPattern.behavior.memento;

/**
 *	ԭ��������һ���ؼ�״̬ 
 **/
public class Originator {
	
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//���ɱ���
	public Memento createMemento(){
		return new Memento(state);
	}
	
	//��ԭ״̬
	public void useMemento(Memento m){
		this.state = m.getState();
	}
	
	public void showState(){
		System.out.println(state);
	}
	
}
