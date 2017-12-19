package test.framework.guava.basicUtilities.objects;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * guava 1.3 Objects常见方法 简化Object的方法
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
		// 当一个对象中的字段可以为null时，实现Object.equals方法会很痛苦，因为不得不分别对它们进行null检查。使用Objects.equal帮助你执行null敏感的equals判断，从而避免抛出NullPointerException。例如:
		// 注意：JDK7引入的Objects类提供了一样的方法Objects.equals。
		Objects.equal("a", "a"); // returns true
		Objects.equal(null, "a"); // returns false
		Objects.equal("a", null); // returns false
		Objects.equal(null, null); // returns true

		// hashCode
		// 用对象的所有字段作散列[hash]运算应当更简单。Guava的Objects.hashCode(Object...)会对传入的字段序列计算出合理的、顺序敏感的散列值。你可以使用Objects.hashCode(field1,
		// field2, …, fieldn)来代替手动计算散列值。
		// 注意：JDK7引入的Objects类提供了一样的方法Objects.hash(Object...)
		Object obj = new Object();
		Object obj2 = new Object();
		System.out.println(Objects.hashCode(obj));
		System.out.println(Objects.hashCode(obj2));
		System.out.println(Objects.hashCode(obj, obj2));

		// 好的toString方法在调试时是无价之宝，但是编写toString方法有时候却很痛苦。使用
		// Objects.toStringHelper可以轻松编写有用的toString方法。例如：
		System.out.println(Objects.toStringHelper(obj).add("x", 1).toString());// Returns
																				// "ClassName{x=1}"
		System.out.println(Objects.toStringHelper("MyObject").add("x", 1)
				.toString());// Returns "MyObject{x=1}"

	}
	
	// compare/compareTo
//  实现一个比较器[Comparator]，或者直接实现Comparable接口有时也伤不起。考虑一下这种情况：
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
	// 这部分代码太琐碎了，因此很容易搞乱，也很难调试。我们应该能把这种代码变得更优雅，为此，Guava提供了ComparisonChain。
	// ComparisonChain执行一种懒比较：它执行比较操作直至发现非零的结果，在那之后的比较输入将被忽略。
	// 查看源代码打印帮助
	public int compareTo(ObjectsTest that) {
		return ComparisonChain.start()
				.compare(this.lastName, that.lastName)
				.compare(this.firstName, that.firstName)
				.compare(this.zipCode, that.zipCode, Ordering.natural().nullsLast()).result();
	}
	// 这种Fluent接口风格的可读性更高，发生错误编码的几率更小，并且能避免做不必要的工作。更多Guava排序器工具可以在下一节里找到。

}
