package test.small.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//CLASS,RUNTIME,SOURCE
//class表示注解信息保留在class文件（字节码）中，运行时不会被虚拟机读取
//runtime表示保留在class文件中，且运行时会被虚拟机读取
//source表示编译器会抛弃注解信息，不保存在class文件中，只存在源文件中
public @interface MyAnnotation {

	// 有默认值的，在使用时可以不设置，没默认值的必须设置
	String hello() default "gege";

	String world();

	int[] array() default { 2, 4, 5, 6 };

	EnumTest lamp();

	MyTarget lannotation() default @MyTarget(value = "ddd");

	Class style() default String.class;

}
