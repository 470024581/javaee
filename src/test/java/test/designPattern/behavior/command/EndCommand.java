package test.designPattern.behavior.command;

public class EndCommand implements Command {
	
	//������Ӧ�Ľ����߶���
	private Receiver receiver = null;
	
	public EndCommand(Receiver receiver){
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// ת�������߶���ķ������ý�����������ִ�й���
		receiver.end();
	}

}
