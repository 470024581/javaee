package test.designPattern.behavior.command;

public class StartCommand implements Command {
	
	//������Ӧ�Ľ����߶���
	private Receiver receiver = null;
	
	public StartCommand(Receiver receiver){
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		// ת�������߶���ķ������ý�����������ִ�й���
		receiver.start();
	}

}
