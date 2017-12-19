package test.designPattern.creational.builder;

/**
 *	Director：监督者 ，构造一个使用Builder接口的对象。
 *	
 **/
public class Director {
	
	private Builder builder;
	
	public Director(Builder builder){
		this.builder = builder;
	}
	
	public void build(){
		builder.buildPart1();
		builder.buildPart2();
	}

}
