package test.designPattern.structural.proxy.static_;

/**
 * ����ģʽ��Ϊ���������ṩһ�ִ����Կ����������ķ���
 * ���õĴ���ģʽ��Զ�̴��������������������ָ��
 * ��̬����ģʽ������ʹ�ü̳л����Ǿۺϵķ�ʽʵ�֡�
 * �̳еķ�ʽ��������ʵ�־�����߼��������̫ǿ
 * �ۺϵķ�ʽ����������ʵ�ֵ������ܣ�����ʱ��ɾ�����߼���������
 **/
public class Client {

	public static void main(String[] args) {
		ProxySubject proxy = new ProxySubject();
		proxy.request();
	}

}
