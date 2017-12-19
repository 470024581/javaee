package test.designPattern.creational.builder;

/**
 *	创建者模式：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示 
 *	适用性：
 *	1.当创建复杂对象的算法应该独立于该对象的组成部分以及他们的装配方式时
 *	2.当构造过程必须允许被构造的对象有不同的表示时
 **/
public class Client {
	
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.build();
		Product product = builder.retrieveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}

}
