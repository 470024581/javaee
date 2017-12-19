package test.designPattern.behavior.command;

public class EndCommand implements Command {
	
	//持有相应的接收者对象
	private Receiver receiver = null;
	
	public EndCommand(Receiver receiver){
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// 转调接收者对象的方法，让接收者来真正执行功能
		receiver.end();
	}

}
