package test.designPattern.structural.facade;

public class DrawerFacade {
	
	private DrawerOne drawerOne = new DrawerOne();
	
	private DrawerTwo drawerTwo = new DrawerTwo();
	
	public void open(){
		drawerOne.open();
		drawerTwo.open();
	}

}
