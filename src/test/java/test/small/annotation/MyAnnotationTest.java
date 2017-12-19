package test.small.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnnotation(hello = "beijing", world = "shanghai", array = {}, lamp = EnumTest.RED, style = int.class)
public class MyAnnotationTest {
	@MyAnnotation(lannotation = @MyTarget(value = "baby"), world = "shanghai", array = {
			1, 2, 3 }, lamp = EnumTest.YELLOW)
	@Deprecated
	@SuppressWarnings("")
	public void output(String str) {
		System.out.println("output something!" + str);
	}

	public static void main(String[] args) throws Exception {
		MyAnnotationTest myTest = new MyAnnotationTest();
		Class<MyAnnotationTest> c = MyAnnotationTest.class;
		// 也可以获取类（c）的注解信息
		
		// 获取指定方法（参数为方法名，以及参数类型）
		Method method = c.getMethod("output", new Class[] {String.class});
		// 如果MyAnnotationTest类名上有注解@MyAnnotation修饰，则为true
		if (MyAnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
			System.out.println("have @MyAnnotation");
		}
		// 如果output方法被@MyAnnotation修饰，则为true
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			method.invoke(myTest, new Object[]{"123"});
//			method.invoke(myTest, null); // 调用output方法
			// 获取方法上注解@MyAnnotation的信息
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			System.out.println(hello + ", " + world);// 打印属性hello和world的值
			System.out.println(myAnnotation.array().length);// 打印属性array数组的长度
			System.out.println(myAnnotation.lannotation().value()); // 打印属性lannotation的值
			System.out.println(myAnnotation.style());
			System.out.println(myAnnotation.lamp());
		}
		// 得到output方法上的所有注解，当然是被RetentionPolicy.RUNTIME修饰的
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
		}
	}
}
