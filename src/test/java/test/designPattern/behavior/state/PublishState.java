package test.designPattern.behavior.state;

public class PublishState implements State {

	@Override
	public void handle(StateMachine machine) {
		System.out.println("publish...");
		machine.setCuurentState(new CompletedState());
	}

}
