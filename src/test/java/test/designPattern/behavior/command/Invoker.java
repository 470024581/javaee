package test.designPattern.behavior.command;

public class Invoker {
	
	//持有命令对象
	private Command startCommand;
	
	private Command endCommand;
	
	public Command getStartCommand() {
		return startCommand;
	}

	public void setStartCommand(Command startCommand) {
		this.startCommand = startCommand;
	}

	public Command getEndCommand() {
		return endCommand;
	}

	public void setEndCommand(Command endCommand) {
		this.endCommand = endCommand;
	}

	public void start(){
		startCommand.execute();
	}

	public void end(){
		endCommand.execute();
	}

}
