package test.designPattern.behavior.memento;

/**
 *	原发器。有一个关键状态 
 **/
public class Originator {
	
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	//生成备份
	public Memento createMemento(){
		return new Memento(state);
	}
	
	//还原状态
	public void useMemento(Memento m){
		this.state = m.getState();
	}
	
	public void showState(){
		System.out.println(state);
	}
	
}
