package test.designPattern.behavior.state;

public class StateMachine {
	
	private State cuurentState;

	public State getCuurentState() {
		return cuurentState;
	}

	public void setCuurentState(State cuurentState) {
		this.cuurentState = cuurentState;
	}
	
}
