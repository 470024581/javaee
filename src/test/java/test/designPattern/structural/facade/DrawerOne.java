package test.designPattern.structural.facade;

/**
 * drawer：抽屉，出票人
 * 
 **/
public class DrawerOne {
	
	public void open(){
		System.out.println("第一个抽屉被打开！");
		getKey();
	}
	
	public void getKey(){
		System.out.println("得到第二个抽屉钥匙！");
	}

}
