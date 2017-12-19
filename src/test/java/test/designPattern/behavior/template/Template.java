package test.designPattern.behavior.template;

public abstract class Template {
	
	public final void workTemplate(){
		checkIn();
		work();
		//�������ũ�͵üӰ�
		if(isCoder()){
			workOvertime();
		}
		checkOut();
	}
	
	public final void checkIn(){
		System.out.println("�ϰ�򿨣�");
	}
	
	public abstract void work();
	
	public void workOvertime(){
		System.out.println("�Ӱ���...");
	}
	
	public final void checkOut(){
		System.out.println("�°�򿨣�");
	}
	
	/**
	 *	hook ���Ӻ������ṩһ��Ĭ�ϻ�յ�ʵ�֣����������������о����Ƿ�ҹ��Լ���ιҹ�
	 *	�Ƿ�����ũ������ǾͼӰ� 
	 **/
	public boolean isCoder(){
		return false;
	}
	
}
