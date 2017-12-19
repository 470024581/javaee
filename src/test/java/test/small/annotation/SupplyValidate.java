package test.small.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface SupplyValidate {
	
	/**
	 *	�Ƿ������֤��Ĭ��false���ܺ���
	 */
	boolean ignore() default false;
	
	/**
	 *	�Ƿ����Ϊ�գ�Ĭ��Ϊtrue������Ϊ��
	 */
	boolean isNull() default true;
	
	/**
	 * �ַ�����󳤶ȣ�-1��ʾ��У�飨ֻ���String�ͣ�
	 */
	int maxLength() default -1;
	
	/**
	 * �ַ�����С���ȣ�-1��ʾ��У�飨ֻ���String�ͣ�
	 */
	int minLength() default -1;
	
	/**
	 * �ṩ��֤��������ʽ 
	 **/
	String reg() default "";
	
	/**
	 * ������Ϣ��ʾ
	 */
	String errorMessage() default "";

}
