package test.designPattern.creational.singleton;

/**
 *	单例模式：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *	适用性：1.当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时
 *		2.当这个唯一实例应该是通过子类化可扩展的，且客户应该无需更改代码就能使用一个扩展的实例时
 *	如何创建单例类：1.创建一个私有静态类属性，2.创建一个私有构造器，3.创建一个静态获取方法
 *	饿汉模式（类加载时创建单例对象，属性中初始化单例对象，线程安全的）
 *	懒汉模式（调用时创建单例对象，多线程不安全）
 **/
public class Singleton {
	private static Singleton singleton = null;
	private Singleton(){
		
	}
	public static Singleton getInstance(){ 
		//懒汉模式
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
