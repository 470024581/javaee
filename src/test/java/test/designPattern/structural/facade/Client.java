package test.designPattern.structural.facade;

/**
 * 外观模式：为子系统中的异族接口提供一个一致的界面（把多个方法的调用封装成一个接口，类似service层控制事务一样）
 * 适用性：1.当你要为一个复杂子系统提供一个简单接口时。（子系统往往因为不断演化而变得越来越复杂）
 * 		2.客户端与抽象的实现部分之间存在着很大的依赖性。（可以有效的分离，提高子系统的独立性，可移植性）
 * 		3.当你需要构建一个层次结构的子系统时，用facade定义子系统中每层的入口点（如果子系统之间是相互依赖的，你可以让他们仅通过façade进行通讯，简化它们之间的依赖关系）
 * 与其他模式的区别：适配器将一个对象包装起来以改变其接口，装饰者将一个对象包装起来增加新的行为和责任，外观将一群对象包装起来简化其接口调用
 **/
public class Client {

	public static void main(String[] args) {
		DrawerFacade drawerFacade = new DrawerFacade();
		drawerFacade.open();//依次打印
	}

}
