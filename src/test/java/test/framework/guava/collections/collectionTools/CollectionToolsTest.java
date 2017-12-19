package test.framework.guava.collections.collectionTools;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * guava 2.3-集合工具类
 * 	我们用相对直观的方式把工具类与特定集合接口的对应关系归纳如下：
	集合接口		属于JDK还是Guava	对应的Guava工具类
	Collection	JDK				Collections2：不要和java.util.Collections混淆
	List		JDK				Lists
	Set			JDK				Sets
	SortedSet	JDK				Sets
	Map			JDK				Maps
	SortedMap	JDK				Maps
	Queue		JDK				Queues
	Multiset	Guava			Multisets
	Multimap	Guava			Multimaps
	BiMap		Guava			Maps
	Table		Guava			Tables
 * 
 * @author lliang
 *
 */
public class CollectionToolsTest {

	public static void main(String[] args) {
		test();
	}
	
	public static void test(){
		// 工厂静态方法
		// 不用重复声明泛型，且可以直接指定值或者长度
		List<String> list = Lists.newArrayList("12","23");
		list = Lists.newArrayListWithExpectedSize(1);
		list.add("1");
		list.add("2");
		list.add("3");
		list = Lists.newArrayListWithCapacity(1);
		list.add("1");
		list.add("2");
		list.add("3");
		
		// Lists
		List<List<String>> subList = Lists.partition(list, 1);// 按指定大小分隔成2个List
		System.out.println(subList.size());// 2
		List<String> reverseList = Lists.reverse(list);// 顺序倒过来的List
		// 具体实现类型		工厂方法
//		ArrayList		basic, with elements, from Iterable, with exact capacity, with expected size, from Iterator
//		LinkedList		basic, from Iterable
		
		// Sets 
		Set<String> set = Sets.newHashSet("1","2","3","5");
		Set<String> set1 = Sets.newHashSet("2","3","4");
		SetView<String> sv = Sets.union(set, set);// 全集
		Sets.intersection(set, set);// 交集
		Sets.difference(set, set1);//[1,5]  返回set里的元素没有在set1中出现的元素集合
		Sets.symmetricDifference(set1, set);//[4,1,5]  返回不重复集合
		sv.copyInto(set);// 返回复制对象
		ImmutableSet<String> is = sv.immutableCopy();// 返回自己的不可变复制对象
		Sets.cartesianProduct(set, set1);// {{1,2},{1,3},{1,4},{2,2}...} 返回所有集合的笛卡尔积（各个元素分别跟其他元素组合）
		Sets.powerSet(set1);// {{},{1}...} 返回指定集合的所有子集
//		具体实现类型		工厂方法
//		HashSet			basic, with elements, from Iterable, with expected size, from Iterator
//		LinkedHashSet	basic, from Iterable, with expected size
//		TreeSet			basic, with Comparator, from Iterable
		
		// Maps
		Set<String> strings = Sets.newHashSet("1","23");
		ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strings,
		    new Function<String, Integer> () {
		        public Integer apply(String string) {
		            return string.length();
		        }
		    }); // {1:"1",2:"23"} 返回以字段长度为key，元素为value的map（如果有相同的属性，会报错，可使用Multimaps.index方法）
		Map<Integer, String> mapIs = Maps.newHashMap();
		mapIs.put(1, "2");
		mapIs.put(2, "23");
		mapIs.put(3, "3");
		mapIs.put(4, "4");
		MapDifference<Integer, String> md = Maps.difference(mapIs, stringsByIndex);// 
		Map<Integer, String> common = md.entriesInCommon();//{2=23} 键值都相同的元素集合
		Map<Integer, ValueDifference<String>> differing = md.entriesDiffering();//{1=(2, 1)} 键相同，值不同
		Map<Integer, String> left = md.entriesOnlyOnLeft();// {3=3, 4=4} 左边map中有（key），右边没有的元素集合
		Map<Integer, String> right =  md.entriesOnlyOnRight();// {} 右边有，左边没有
		
		// Iterables
//		常规方法
//		concat(Iterable<Iterable>)			串联多个iterables的懒视图*								concat(Iterable...)
//		frequency(Iterable, Object)			返回对象在iterable中出现的次数								与Collections.frequency (Collection,   Object)比较;Multiset
//		partition(Iterable, int)			把iterable按指定大小分割，得到的子集都不能进行修改操作				Lists.partition(List, int);paddedPartition(Iterable, int)
//		getFirst(Iterable, T default)		返回iterable的第一个元素，若iterable为空则返回默认值			与Iterable.iterator(). next()比较;FluentIterable.first()
//		getLast(Iterable)					返回iterable的最后一个元素，若iterable为空则抛出NoSuchElementException		getLast(Iterable, T default);FluentIterable.last()
//		elementsEqual(Iterable, Iterable)	如果两个iterable中的所有元素相等且顺序一致，返回true				与List.equals(Object)比较
//		unmodifiableIterable(Iterable)		返回iterable的不可变视图									与Collections.unmodifiableCollection(Collection)比较
//		limit(Iterable, int)				限制iterable的元素个数限制给定值							FluentIterable.limit(int)
//		getOnlyElement(Iterable)			获取iterable中唯一的元素，如果iterable为空或有多个元素，则快速失败	getOnlyElement(Iterable, T default)
		
	}


}
