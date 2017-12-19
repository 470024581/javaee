package test.designPattern.creational.builder;

/**
 *	�����ߣ�Ϊ����һ��Product����ĸ�������ָ������ӿ�
 *	
 **/
public interface Builder {
	
	/**
	 *	��������1
	 **/
	public void buildPart1();
	
	/**
	 *	��������2
	 **/
	public void buildPart2();
	
	/**
	 *	retrieve��ȡ�أ��ָ�
	 *	ȡ�ز�Ʒ
	 **/
	public Product retrieveResult();

}
