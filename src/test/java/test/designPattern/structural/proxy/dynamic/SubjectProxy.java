package test.designPattern.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectProxy implements InvocationHandler {
	
	private ISubject subject;
	
	public SubjectProxy(ISubject subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] parameters)
			throws Throwable {
		// ����ǰ���߼�����
		// ���������ø÷���ʱ������������invoke������ʵ����method.invokeͨ��������õ�Subject()����
		Object obj = method.invoke(subject, parameters);
		// ���ú���߼�����
		return obj;
	}

}
