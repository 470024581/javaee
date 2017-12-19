package test.designPattern.creational.builder;

/**
 *	Director���ල�� ������һ��ʹ��Builder�ӿڵĶ���
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
