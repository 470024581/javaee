package test.designPattern.structural.flyweight;

/**
 * ������Ԫ���󣬲���Ϊ�ڲ�״̬������еĻ������Ӵ洢�ռ�
 * 
 **/
public class ConcreteFlyweight implements Flyweight {

	private Character intrinsicState = null;
	
	public ConcreteFlyweight(Character intrinsicState) {
		this.intrinsicState = intrinsicState;
	}
	
	@Override
	public void operation(String state) {
		System.out.println("Intrinsic State = " + this.intrinsicState);
		System.out.println("Extrinsic State = " + state);
	}

}
