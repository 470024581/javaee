package test.designPattern.structural.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ������������flyweight����ȷ������Ĺ���flyweight
 **/
public class FlyweightFactory {
	
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	
	public Flyweight factory(Character state) {
		//�ȴӻ����в��Ҷ���
		Flyweight fly = files.get(state);
		if(fly == null) {
			//������󲻴��ڣ��ʹ���һ���µĶ���
			fly = new ConcreteFlyweight(state);
			//��ӵ�������
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
