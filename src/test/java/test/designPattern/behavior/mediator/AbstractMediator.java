package test.designPattern.behavior.mediator;

public abstract class AbstractMediator {
	
	protected AbstractColleague A;
	protected AbstractColleague B;
	
	public AbstractMediator(AbstractColleague a, AbstractColleague b){
		this.A = a;
		this.B = b;
	}
	
	public abstract void AaffectB();
	
	public abstract void BaffectA();
	
}
