package test.designPattern.behavior.command;

/**
 *	接收者角色 
 **/
public class Receiver {
	/**
	 *	真正执行命令相应的操作 
	 **/
	public void start(){
		System.out.println("开始！");
	}
	
	public void end(){
		System.out.println("结束！");
	}
}
