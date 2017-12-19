package test.designPattern.structural.proxy.static_;

/**
 * 代理模式：为其他对象提供一种代理以控制这个对象的访问
 * 常用的代理模式：远程代理，虚代理，保护代理，智能指引
 * 静态代理模式：可以使用继承或者是聚合的方式实现。
 * 继承的方式：单个类实现具体的逻辑，耦合性太强
 * 聚合的方式：单个代理实现单个功能，调用时组成具体的逻辑，灵活调用
 **/
public class Client {

	public static void main(String[] args) {
		ProxySubject proxy = new ProxySubject();
		proxy.request();
	}

}
