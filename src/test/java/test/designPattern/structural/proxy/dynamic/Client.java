package test.designPattern.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 动态代理jdk实现：代理类通过调用被代理类的相关方法，提供预处理、过滤、事后处理等服务。
 * 动态代理利用java的反射机制，动态实现的代理机制。
 * jdk的动态代理是基于接口的（不基于接口的有CGLIB）
 * 动态代理的实现思路：1.声明一段源码（动态生成代理类，通过String写入到.java文件中）
 * 		2.编译源码（JDK Compiler API），产生新的类（代理类）
 * 		3.将这个类加载到内存中，产生一个新的对象（代理对象）
 * 		4.返回代理对象（并使用）
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
//				new Class[] { ISubject.class }, new InvocationHandler() { // 这里是匿名内部类实例，实现
//					// InvocationHandler接口，也可以抽出
//					@Override
//					public Object invoke(Object proxy, Method method,
//							Object[] parameters) throws Throwable {
//						// 调用前的逻辑处理
//						Object obj = method.invoke(Subject, parameters);
//						// 调用后的逻辑处理
//						return obj;
//					}
//				});
//		proxySubject.run();// 代理对象调用该方法时，会调用上面的invoke方法。实际是method.invoke通过反射调用的Subject()方法
	}

}
