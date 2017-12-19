package test.small.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//CLASS,RUNTIME,SOURCE
//class��ʾע����Ϣ������class�ļ����ֽ��룩�У�����ʱ���ᱻ�������ȡ
//runtime��ʾ������class�ļ��У�������ʱ�ᱻ�������ȡ
//source��ʾ������������ע����Ϣ����������class�ļ��У�ֻ����Դ�ļ���
public @interface MyAnnotation {

	// ��Ĭ��ֵ�ģ���ʹ��ʱ���Բ����ã�ûĬ��ֵ�ı�������
	String hello() default "gege";

	String world();

	int[] array() default { 2, 4, 5, 6 };

	EnumTest lamp();

	MyTarget lannotation() default @MyTarget(value = "ddd");

	Class style() default String.class;

}
