package test.designPattern.behavior.state;

import java.io.IOException;


public class Client {

	public static void main(String[] args) throws IOException {
		// 声明一个状态机
		StateMachine machine = new StateMachine();
		State start = new StartState();
		machine.setCuurentState(start);
		while(machine.getCuurentState() != null){
			machine.getCuurentState().handle(machine);
		}
	}

}
