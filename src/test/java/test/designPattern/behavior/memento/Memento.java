package test.designPattern.behavior.memento;

/**
 *	备忘录，用来对原发器对象的状态state进行保存
 **/
public class Memento {
	
	private String state;
	
	public Memento(String state){
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
