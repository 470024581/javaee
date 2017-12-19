package test.designPattern.creational.builder;

/**
 *	具体创建者：实现Builder接口以构造和装配该产品的各个部件。定义并明确它所创建的表示。提供一个检索产品的接口。
 **/
public class ConcreteBuilder implements Builder {
	
	private Product product = new Product();

	@Override
	public void buildPart1() {
		product.setPart1("编码：111");
	}

	@Override
	public void buildPart2() {
		product.setPart2("名称：222");
	}

	@Override
	public Product retrieveResult() {
		return product;
	}

}
