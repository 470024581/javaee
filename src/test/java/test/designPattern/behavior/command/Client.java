package test.designPattern.behavior.command;

public class Client {
	public static void main(String[] args) {
		//����������
		Receiver receiver = new Receiver();
		//����������󣬰����Ľ�����
		Command startCommand = new StartCommand(receiver);
		Command endCommand = new EndCommand(receiver);
		//���������ߣ�������������ý�ȥ
		Invoker invoker = new Invoker();
		invoker.setEndCommand(endCommand);
		invoker.setStartCommand(startCommand);
		
		//ִ�з���
		invoker.start();
		invoker.end();
		invoker.start();
	}
}
