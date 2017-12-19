package test.designPattern.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * ��̬����jdkʵ�֣�������ͨ�����ñ����������ط������ṩԤ�������ˡ��º���ȷ���
 * ��̬��������java�ķ�����ƣ���̬ʵ�ֵĴ�����ơ�
 * jdk�Ķ�̬�����ǻ��ڽӿڵģ������ڽӿڵ���CGLIB��
 * ��̬�����ʵ��˼·��1.����һ��Դ�루��̬���ɴ����࣬ͨ��Stringд�뵽.java�ļ��У�
 * 		2.����Դ�루JDK Compiler API���������µ��ࣨ�����ࣩ
 * 		3.���������ص��ڴ��У�����һ���µĶ��󣨴������
 * 		4.���ش�����󣨲�ʹ�ã�
 **/
public class Client {

	public static void main(String[] args) {
		 final ISubject subject = new Subject();
		 ISubject proxy = (ISubject)
		 Proxy.newProxyInstance(ISubject.class.getClassLoader(),
				 subject.getClass().getInterfaces(), new SubjectProxy(subject));
		 proxy.run();
		 proxy.stop();

//		final ISubject Subject = new Subject();
//		ISubject proxySubject = (ISubject) Proxy.newProxyInstance(
//				ISubject.class.getClassLoader(),
//				new Class[] { ISubject.class }, new InvocationHandler() { // �����������ڲ���ʵ����ʵ��
//					// InvocationHandler�ӿڣ�Ҳ���Գ��
//					@Override
//					public Object invoke(Object proxy, Method method,
//							Object[] parameters) throws Throwable {
//						// ����ǰ���߼�����
//						Object obj = method.invoke(Subject, parameters);
//						// ���ú���߼�����
//						return obj;
//					}
//				});
//		proxySubject.run();// ���������ø÷���ʱ������������invoke������ʵ����method.invokeͨ��������õ�Subject()����
	}

}
