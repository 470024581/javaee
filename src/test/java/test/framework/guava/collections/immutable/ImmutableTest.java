package test.framework.guava.collections.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * guava 2.1-不可变集合
 * 不可变对象有很多优点，包括：（不接受null值）
		当对象被不可信的库调用时，不可变形式是安全的；
		不可变对象被多个线程调用时，不存在竞态条件问题
		不可变集合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合都比它们的可变形式有更好的内存利用率（分析和测试细节）；
		不可变对象因为有固定不变，可以作为常量来安全使用。
   JDK也提供了Collections.unmodifiableXXX方法把集合包装为不可变形式，但我们认为不够好：
		笨重而且累赘：不能舒适地用在所有想做防御性拷贝的场景；
		不安全：要保证没人通过原集合的引用进行修改，返回的集合才是事实上不可变的；
		低效：包装过的集合仍然保有可变集合的开销，比如并发修改的检查、散列表的额外空间，等等。	
 * @author lliang
 *
 */
public class ImmutableTest {

	public static void main(String[] args) {
		// 不可变集合的创建
		ImmutableSet<String> SET = ImmutableSet.of("123", "456");
		ImmutableSet<String> COPY_SET = ImmutableSet.copyOf(SET);
		ImmutableSet<String> BUILD_SET = ImmutableSet.<String>builder().add("234").addAll(COPY_SET).build();
		
		// 所有的不可变集合都拥有asList方法，
		ImmutableList<String> iList = BUILD_SET.asList();
		
//		细节：关联可变集合和不可变集合
//		可变集合接口		属于JDK还是Guava	不可变版本
//		Collection		JDK				ImmutableCollection
//		List			JDK				ImmutableList
//		Set				JDK				ImmutableSet
//		SortedSet/NavigableSet	JDK		ImmutableSortedSet
//		Map				JDK				ImmutableMap
//		SortedMap		JDK				ImmutableSortedMap
//		Multiset		Guava			ImmutableMultiset
//		SortedMultiset	Guava			ImmutableSortedMultiset
//		Multimap		Guava			ImmutableMultimap
//		ListMultimap	Guava			ImmutableListMultimap
//		SetMultimap		Guava			ImmutableSetMultimap
//		BiMap			Guava			ImmutableBiMap
//		ClassToInstanceMap	Guava		ImmutableClassToInstanceMap
//		Table			Guava			ImmutableTable
	}

}
