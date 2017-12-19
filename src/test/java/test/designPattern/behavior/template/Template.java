package test.designPattern.behavior.template;

public abstract class Template {
	
	public final void workTemplate(){
		checkIn();
		work();
		//如果是码农就得加班
		if(isCoder()){
			workOvertime();
		}
		checkOut();
	}
	
	public final void checkIn(){
		System.out.println("上班打卡！");
	}
	
	public abstract void work();
	
	public void workOvertime(){
		System.out.println("加班中...");
	}
	
	public final void checkOut(){
		System.out.println("下班打卡！");
	}
	
	/**
	 *	hook 钩子函数，提供一个默认或空的实现，具体的子类可以自行决定是否挂钩以及如何挂钩
	 *	是否是码农，如果是就加班 
	 **/
	public boolean isCoder(){
		return false;
	}
	
}
