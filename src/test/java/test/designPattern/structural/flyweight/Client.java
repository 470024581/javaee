package test.designPattern.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式：运用共享技术有效地支持大量细粒度的对象
 * （实际运用不常用，会使系统复杂化，通常是系统底层为解决性能问题
 * 如String、Integer、Long类，Interger和Long类型只支持-128到127比较常用，超过此范围便不使用享元技术
 * new Integer(127)==new Integer(127)//true
 * new Integer(128)==new Integer(128)//false）
 * 适用性：1.一个应用程序使用了大量的同类对象
 * 		2.完全由于使用大量对象，造成比较大的内存开销
 * 		3.对象大多数状态都可变为外部状态
 * 		4.如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象
 * 		5.应用程序不依赖于对象标识，由于享元对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值
 **/
public class Client {
	
	public static void main(String[] args) {
		List<Character> compositeState = new ArrayList<Character>();
        compositeState.add('a');
        compositeState.add('b');
        compositeState.add('c');
        compositeState.add('a');
        
        FlyweightFactory flyFactory = new FlyweightFactory();
        Flyweight compositeFly1 = flyFactory.factory(compositeState);
        Flyweight compositeFly2 = flyFactory.factory(compositeState);
        compositeFly1.operation("Composite111 Call");
        System.out.println(flyFactory.getFlyweightSize());
        System.out.println("---------------------------------");        
        System.out.println("复合享元模式是否可以共享对象："+(compositeFly1==compositeFly2));//false
        
        Character state = 'a';
        Flyweight fly1 = flyFactory.factory(state);
        Flyweight fly2 = flyFactory.factory(state);
        System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));//true

	}

}
