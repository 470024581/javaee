package test.designPattern.structural.decorator;

/**
 * װ����ģʽ����̬�ĸ�һ���������һЩ�����ְ�𡣱������������
 * �����ԣ�1�ڲ�Ӱ���������������£��Զ�̬��͸���ķ�ʽ�������������ְ��
 * 		2������Щ���Գ�����ְ��
 * 		3�����ܲ�����������ķ���������չʱ
 * ������2���ʵ�ֺͼ̳й�ϵ���������
 **/
public class Client {

	public static void main(String[] args) {
		Component com = new ConcreteComponent();
		Component fish = new Fish(com);
		Component bird = new Bird(fish);
		bird.run();//bird fly��
		fish.run();//run...
	}
	
}
