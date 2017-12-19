package test.designPattern.behavior.mediator;

public abstract class AbstractColleague {
	
	protected int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	//ע������Ĳ�����ͬ����
	public abstract void setNumber(int number, AbstractColleague coll);
	
	//ע������Ĳ�����һ���н��� 
	public abstract void setNumber(int number, AbstractMediator am);

}
