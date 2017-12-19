package test.designPattern.creational.singleton;

/**
 *	����ģʽ����֤һ�������һ��ʵ�������ṩһ����������ȫ�ַ��ʵ㡣
 *	�����ԣ�1.����ֻ����һ��ʵ�����ҿͻ����Դ�һ��������֪�ķ��ʵ������ʱ
 *		2.�����Ψһʵ��Ӧ����ͨ�����໯����չ�ģ��ҿͻ�Ӧ��������Ĵ������ʹ��һ����չ��ʵ��ʱ
 *	��δ��������ࣺ1.����һ��˽�о�̬�����ԣ�2.����һ��˽�й�������3.����һ����̬��ȡ����
 *	����ģʽ�������ʱ�����������������г�ʼ�����������̰߳�ȫ�ģ�
 *	����ģʽ������ʱ�����������󣬶��̲߳���ȫ��
 **/
public class Singleton {
	private static Singleton singleton = null;
	private Singleton(){
		
	}
	public static Singleton getInstance(){ 
		//����ģʽ
		if(singleton == null){
			singleton = new Singleton();
		}
		return singleton; 
	}
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1.equals(singleton2));//true
	}
}
