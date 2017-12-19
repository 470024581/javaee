package test.designPattern.structural.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建并管理复合flyweight对象，确保合理的共享flyweight
 **/
public class FlyweightFactory {
	
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	
	public Flyweight factory(Character state) {
		//先从缓存中查找对象
		Flyweight fly = files.get(state);
		if(fly == null) {
			//如果对象不存在，就创建一个新的对象
			fly = new ConcreteFlyweight(state);
			//添加到缓存中
			files.put(state, fly);
		}
		return fly;
	}
	
	public Flyweight factory(List<Character> compositeState) {
		ConcreteCompositeFlyweight flyweight = new ConcreteCompositeFlyweight();
		for(Character state : compositeState){
			flyweight.add(state, this.factory(state));
		}
		return flyweight;
	}
	
	public int getFlyweightSize() {
		return files.size();
	}

}
