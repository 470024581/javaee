package test.designPattern.structural.facade;

/**
 * drawer�����룬��Ʊ��
 * 
 **/
public class DrawerTwo {
	
	public void open(){
		System.out.println("�ڶ������뱻�򿪣�");
		getFile();
	}
	
	public void getFile(){
		System.out.println("�õ���Ҫ�ļ���");
	}

}
