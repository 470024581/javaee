package test.framework.guava.basicUtilities.ordering;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * guava 1.4-排序器 Guava链式风格比较器[Comparator]的实现，它可以用来为构建复杂的比较器，以完成集合排序的功能。
 * 
 * @author lliang
 * 
 */
public class OrderingTest implements Comparable<OrderingTest> {
	
	private String sortby;

	public static void main(String[] args) {
		// 创建排序器
		Ordering<OrderingTest> order = Ordering.natural();// 对可排序类型做自然排序，如数字按大小，日期按先后排序
		Ordering<Object> o = Ordering.usingToString();// 按对象 的字符串形式做字典排序
		Ordering.from(o);// 把给定的Comparator转化为排序器
		// 实现自定义排序器，除了from方法，也可以直接继承Ordering:
		Ordering<String> byLengthOrdering = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};
		
		// 链式调用方法：可以由给定的排序器衍生出其他的排序器
		order.reverse();// 获取语义相反的排序器
		order.nullsFirst();// 使用当前排序器，但额外把null值排到最前面
		order.nullsLast();// 使用当前排序器，但额外把null值排到最后面
		order.compound(o);// 合成一个比较器，以处理当前排序器中的相等情况
		Ordering<Iterable<OrderingTest>> it = order.lexicographical(); // 基于处理类型T的排序器，返回该类型的可迭代对象Iterable<T>的排序器
		Ordering.natural().onResultOf(new Function<OrderingTest, String>(){
			@Override
			public String apply(OrderingTest input) {
				return input.sortby;
			}
		}); // 对集合中元素调用Function，再按返回值用当前排序器排序
		
//		当阅读链式调用产生的排序器时，应该从后往前读。上面的例子中，排序器首先调用apply方法获取sortedBy值，并把sortedBy为null的元素都放到最前面，然后把剩下的元素按sortedBy进行自然排序。之所以要从后往前读，是因为每次链式调用都是用后面的方法包装了前面的排序器。
//		注：用compound方法包装排序器时，就不应遵循从后往前读的原则。为了避免理解上的混乱，请不要把compound写在一长串链式调用的中间，你可以另起一行，在链中最先或最后调用compound。
//		超过一定长度的链式调用，也可能会带来阅读和理解上的难度。我们建议按下面的代码这样，在一个链中最多使用三个方法。此外，你也可以把Function分离成中间对象，让链式调用更简洁紧凑。
		
		// 运用排序器
//		o.greatestOf(Iterable iterable, int k)  获取可迭代对象中最大的k个元素					leastOf(), greatestOf(Iterator iterator, int k)
//		isOrdered(Iterable)		判断可迭代对象是否已按排序器排序：允许有排序值相等的元素。				isStrictlyOrdered
//		sortedCopy(Iterable)	判断可迭代对象是否已严格按排序器排序：不允许排序值相等的元素。			immutableSortedCopy
//		min(E, E)				返回两个参数中最小的那个。如果相等，则返回第一个参数。				max(E, E)
//		min(E, E, E, E...)		返回多个参数中最小的那个。如果有超过一个参数都最小，则返回第一个最小的参数。	max(E, E, E, E...)
//		min(Iterable)			返回迭代器中最小的元素。如果可迭代对象中没有元素，则抛出NoSuchElementException。	max(Iterable), min(Iterator), max(Iterator)
	
	}

	@Override
	public int compareTo(OrderingTest o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


