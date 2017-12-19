package test.small.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface SupplyClass {
	
	/**
	 *	�Ƿ����Ϊ�գ�Ĭ��Ϊtrue������Ϊ��
	 */
	boolean isNull() default true;

}
