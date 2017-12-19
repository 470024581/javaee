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
		// Ҳ���Ի�ȡ�ࣨc����ע����Ϣ
		
		// ��ȡָ������������Ϊ���������Լ��������ͣ�
		Method method = c.getMethod("output", new Class[] {String.class});
		// ���MyAnnotationTest��������ע��@MyAnnotation���Σ���Ϊtrue
		if (MyAnnotationTest.class.isAnnotationPresent(MyAnnotation.class)) {
			System.out.println("have @MyAnnotation");
		}
		// ���output������@MyAnnotation���Σ���Ϊtrue
		if (method.isAnnotationPresent(MyAnnotation.class)) {
			method.invoke(myTest, new Object[]{"123"});
//			method.invoke(myTest, null); // ����output����
			// ��ȡ������ע��@MyAnnotation����Ϣ
			MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
			String hello = myAnnotation.hello();
			String world = myAnnotation.world();
			System.out.println(hello + ", " + world);// ��ӡ����hello��world��ֵ
			System.out.println(myAnnotation.array().length);// ��ӡ����array����ĳ���
			System.out.println(myAnnotation.lannotation().value()); // ��ӡ����lannotation��ֵ
			System.out.println(myAnnotation.style());
			System.out.println(myAnnotation.lamp());
		}
		// �õ�output�����ϵ�����ע�⣬��Ȼ�Ǳ�RetentionPolicy.RUNTIME���ε�
		Annotation[] annotations = method.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType().getName());
		}
	}
}
