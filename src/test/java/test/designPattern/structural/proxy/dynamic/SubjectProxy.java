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
		// 调用前的逻辑处理
		// 代理对象调用该方法时，会调用上面的invoke方法。实际是method.invoke通过反射调用的Subject()方法
		Object obj = method.invoke(subject, parameters);
		// 调用后的逻辑处理
		return obj;
	}

}
