package test.designPattern.structural.composite;

/**
 * ���ģʽ����������ϳ����νṹ�Ա�ʾ������-���塱�Ĳ�νṹ��ʹ���û��Ե����������϶����ʹ�þ���һ����
 * �����ԣ�1.�����ʾ����Ĳ���-�����νṹ
 * 		2.��ϣ���û�������϶����뵥������Ĳ�ͬ���û���ͳһ��ʹ����Ͻṹ�е����ж���
 * 
 * 
 **/
public abstract class Market {
	String name;  
    public abstract void add(Market m);  
    public abstract void remove(Market m);  
    public abstract void PayByCard();  
}
