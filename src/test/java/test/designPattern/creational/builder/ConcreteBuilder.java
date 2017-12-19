package test.designPattern.creational.builder;

/**
 *	���崴���ߣ�ʵ��Builder�ӿ��Թ����װ��ò�Ʒ�ĸ������������岢��ȷ���������ı�ʾ���ṩһ��������Ʒ�Ľӿڡ�
 **/
public class ConcreteBuilder implements Builder {
	
	private Product product = new Product();

	@Override
	public void buildPart1() {
		product.setPart1("���룺111");
	}

	@Override
	public void buildPart2() {
		product.setPart2("���ƣ�222");
	}

	@Override
	public Product retrieveResult() {
		return product;
	}

}
