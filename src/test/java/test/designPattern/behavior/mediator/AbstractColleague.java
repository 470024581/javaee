package test.designPattern.behavior.mediator;

public abstract class AbstractColleague {
	
	protected int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	//注意这里的参数是同事类
	public abstract void setNumber(int number, AbstractColleague coll);
	
	//注意这里的参数是一个中介者 
	public abstract void setNumber(int number, AbstractMediator am);

}
