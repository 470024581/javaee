package test.designPattern.behavior.state;

public class StartState implements State {

	@Override
	public void handle(StateMachine machine) {
		System.out.println("start to process...");
		machine.setCuurentState(new PublishState());
	}

}
