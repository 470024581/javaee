package test.designPattern.behavior.interpreter;

/**
 *	������ʽ��ɫ 
 **/
public abstract class Expression {
	//���������͸������κ�һ�����ʽ
	public abstract boolean interpreter(Context ctx);
	//�����������ʽ�ڽṹ���Ƿ���ͬ
	public abstract boolean equals(Object obj);
	//���ر��ʽ��hash code
	public abstract int hashCode();
	//�����ʽת�����ַ���
	public abstract String toString();
}
