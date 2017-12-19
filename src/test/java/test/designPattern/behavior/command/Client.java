package test.designPattern.behavior.command;

public class Client {
	public static void main(String[] args) {
		//创建接收者
		Receiver receiver = new Receiver();
		//创建命令对象，绑定它的接收者
		Command startCommand = new StartCommand(receiver);
		Command endCommand = new EndCommand(receiver);
		//创建请求者，把命令对象设置进去
		Invoker invoker = new Invoker();
		invoker.setEndCommand(endCommand);
		invoker.setStartCommand(startCommand);
		
		//执行方法
		invoker.start();
		invoker.end();
		invoker.start();
	}
}
