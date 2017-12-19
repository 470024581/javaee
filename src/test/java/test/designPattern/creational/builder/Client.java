package test.designPattern.creational.builder;

/**
 *	������ģʽ����һ�����Ӷ���Ĺ��������ı�ʾ���룬ʹ��ͬ���Ĺ������̿��Դ�����ͬ�ı�ʾ 
 *	�����ԣ�
 *	1.���������Ӷ�����㷨Ӧ�ö����ڸö������ɲ����Լ����ǵ�װ�䷽ʽʱ
 *	2.��������̱�����������Ķ����в�ͬ�ı�ʾʱ
 **/
public class Client {
	
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.build();
		Product product = builder.retrieveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}

}
