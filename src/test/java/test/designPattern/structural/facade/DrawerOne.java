package test.designPattern.structural.facade;

/**
 * drawer�����룬��Ʊ��
 * 
 **/
public class DrawerOne {
	
	public void open(){
		System.out.println("��һ�����뱻�򿪣�");
		getKey();
	}
	
	public void getKey(){
		System.out.println("�õ��ڶ�������Կ�ף�");
	}

}
