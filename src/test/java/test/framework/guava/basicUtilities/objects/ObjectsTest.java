package test.framework.guava.basicUtilities.objects;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * guava 1.3 Objects�������� ��Object�ķ���
 * 
 * @author lliang
 * 
 */
public class ObjectsTest implements Comparable<ObjectsTest>  {
	
	private String lastName;
	private String firstName;
	private int zipCode;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// equals
		// ��һ�������е��ֶο���Ϊnullʱ��ʵ��Object.equals�������ʹ�࣬��Ϊ���ò��ֱ�����ǽ���null��顣ʹ��Objects.equal������ִ��null���е�equals�жϣ��Ӷ������׳�NullPointerException������:
		// ע�⣺JDK7�����Objects���ṩ��һ���ķ���Objects.equals��
		Objects.equal("a", "a"); // returns true
		Objects.equal(null, "a"); // returns false
		Objects.equal("a", null); // returns false
		Objects.equal(null, null); // returns true

		// hashCode
		// �ö���������ֶ���ɢ��[hash]����Ӧ�����򵥡�Guava��Objects.hashCode(Object...)��Դ�����ֶ����м��������ġ�˳�����е�ɢ��ֵ�������ʹ��Objects.hashCode(field1,
		// field2, ��, fieldn)�������ֶ�����ɢ��ֵ��
		// ע�⣺JDK7�����Objects���ṩ��һ���ķ���Objects.hash(Object...)
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println(Objects.hashCode(obj));
		System.out.println(Objects.hashCode(obj2));
		System.out.println(Objects.hashCode(obj, obj2));

		// �õ�toString�����ڵ���ʱ���޼�֮�������Ǳ�дtoString������ʱ��ȴ��ʹ�ࡣʹ��
		// Objects.toStringHelper�������ɱ�д���õ�toString���������磺
		System.out.println(Objects.toStringHelper(obj).add("x", 1).toString());// Returns
																				// "ClassName{x=1}"
		System.out.println(Objects.toStringHelper("MyObject").add("x", 1)
				.toString());// Returns "MyObject{x=1}"

	}
	
	// compare/compareTo
//  ʵ��һ���Ƚ���[Comparator]������ֱ��ʵ��Comparable�ӿ���ʱҲ�˲��𡣿���һ�����������
//	public int compareTo(ObjectsTest other) {
//	int cmp = lastName.compareTo(other.lastName);
//	if (cmp != 0) {
//		return cmp;
//	}
//	cmp = firstName.compareTo(other.firstName);
//	if (cmp != 0) {
//		return cmp;
//	}
//	return Ints.compare(zipCode, other.zipCode);
//  }
	// �ⲿ�ִ���̫�����ˣ���˺����׸��ң�Ҳ���ѵ��ԡ�����Ӧ���ܰ����ִ����ø����ţ�Ϊ�ˣ�Guava�ṩ��ComparisonChain��
	// ComparisonChainִ��һ�����Ƚϣ���ִ�бȽϲ���ֱ�����ַ���Ľ��������֮��ıȽ����뽫�����ԡ�
	// �鿴Դ�����ӡ����
	public int compareTo(ObjectsTest that) {
		return ComparisonChain.start()
				.compare(this.lastName, that.lastName)
				.compare(this.firstName, that.firstName)
				.compare(this.zipCode, that.zipCode, Ordering.natural().nullsLast()).result();
	}
	// ����Fluent�ӿڷ��Ŀɶ��Ը��ߣ������������ļ��ʸ�С�������ܱ���������Ҫ�Ĺ���������Guava���������߿�������һ�����ҵ���

}
