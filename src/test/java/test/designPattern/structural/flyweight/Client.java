package test.designPattern.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ԫģʽ�����ù�������Ч��֧�ִ���ϸ���ȵĶ���
 * ��ʵ�����ò����ã���ʹϵͳ���ӻ���ͨ����ϵͳ�ײ�Ϊ�����������
 * ��String��Integer��Long�࣬Interger��Long����ֻ֧��-128��127�Ƚϳ��ã������˷�Χ�㲻ʹ����Ԫ����
 * new Integer(127)==new Integer(127)//true
 * new Integer(128)==new Integer(128)//false��
 * �����ԣ�1.һ��Ӧ�ó���ʹ���˴�����ͬ�����
 * 		2.��ȫ����ʹ�ô���������ɱȽϴ���ڴ濪��
 * 		3.��������״̬���ɱ�Ϊ�ⲿ״̬
 * 		4.���ɾ��������ⲿ״̬����ô��������Խ��ٵĹ������ȡ���ܶ������
 * 		5.Ӧ�ó��������ڶ����ʶ��������Ԫ������Ա��������ڸ����������б�Ķ��󣬱�ʶ���Խ�������ֵ
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
        System.out.println("������Ԫģʽ�Ƿ���Թ������"+(compositeFly1==compositeFly2));//false
        
        Character state = 'a';
        Flyweight fly1 = flyFactory.factory(state);
        Flyweight fly2 = flyFactory.factory(state);
        System.out.println("������Ԫģʽ�Ƿ���Թ������" + (fly1 == fly2));//true

	}

}
