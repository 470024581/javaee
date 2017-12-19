package test.small.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
public @interface SupplyValidate {
	
	/**
	 *	是否忽略验证，默认false不能忽略
	 */
	boolean ignore() default false;
	
	/**
	 *	是否可以为空，默认为true，可以为空
	 */
	boolean isNull() default true;
	
	/**
	 * 字符串最大长度，-1表示不校验（只针对String型）
	 */
	int maxLength() default -1;
	
	/**
	 * 字符串最小长度，-1表示不校验（只针对String型）
	 */
	int minLength() default -1;
	
	/**
	 * 提供验证的正则表达式 
	 **/
	String reg() default "";
	
	/**
	 * 错误信息提示
	 */
	String errorMessage() default "";

}
