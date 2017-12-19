package test.designPattern.behavior.mediator;

public class ColleagueA extends AbstractColleague {

	@Override
	public void setNumber(int number, AbstractColleague coll) {
		this.number = number;
		coll.setNumber(number * 100);
	}

	@Override
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.AaffectB();
	}

}
