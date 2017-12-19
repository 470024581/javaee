package test.designPattern.structural.facade;

/**
 * drawer：抽屉，出票人
 * 
 **/
public class DrawerTwo {
	
	public void open(){
		System.out.println("第二个抽屉被打开！");
		getFile();
	}
	
	public void getFile(){
		System.out.println("得到重要文件！");
	}

}
