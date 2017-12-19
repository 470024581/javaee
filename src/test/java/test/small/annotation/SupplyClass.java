package test.small.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.TYPE)
public @interface SupplyClass {
	
	/**
	 *	是否可以为空，默认为true，可以为空
	 */
	boolean isNull() default true;

}
