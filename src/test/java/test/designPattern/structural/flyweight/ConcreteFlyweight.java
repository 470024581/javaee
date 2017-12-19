package test.designPattern.structural.flyweight;

/**
 * 单纯享元对象，并作为内部状态（如果有的话）增加存储空间
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
