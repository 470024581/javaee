package test.designPattern.creational.builder;

/**
 *	建造者：为创建一个Product对象的各个部件指定抽象接口
 *	
 **/
public interface Builder {
	
	/**
	 *	创建部件1
	 **/
	public void buildPart1();
	
	/**
	 *	创建部件2
	 **/
	public void buildPart2();
	
	/**
	 *	retrieve：取回，恢复
	 *	取回产品
	 **/
	public Product retrieveResult();

}
