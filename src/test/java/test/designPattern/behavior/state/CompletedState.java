package test.designPattern.behavior.state;

public class CompletedState implements State {

	@Override
	public void handle(StateMachine machine) {
		System.out.println("completed");
		machine.setCuurentState(null);
	}

}
