package test.framework.guava.collections.newCollections;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableClassToInstanceMap;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;

/***
 * guava 2.2-新集合类型
 * 
 * Muitiset：无序的list和自动计数可重复的set
 * SortedMultiset：与上面相比，有序
 * Multimap：可映射单个值和集合值的set
 * BiMap：键值可以相互转换映射的特殊map（若有相同的value，都转换成key时，因为key要唯一，会报异常）
 * Table：拥有两个可以支持所有类型的键，行和列。提供多种视图以便从各种角度使用
 * ClassToInstanceMap：类型映射实例
 * RangeSet：区间集合
 * RangeMap：”不相交的、非空的区间”到特定值的映射
 * 
 * Multiset的实现，大致对应JDK中Map的各种实现：
		Map					对应的Multiset			是否支持null元素
		HashMap				HashMultiset			是
		TreeMap				TreeMultiset			是（如果comparator支持的话）
		LinkedHashMap		LinkedHashMultiset		是
		ConcurrentHashMap	ConcurrentHashMultiset	否
		ImmutableMap		ImmutableMultiset		否
 * Multimap的实现。在大多数要使用Map<K, Collection<V>>的地方，你都可以使用它们：
  	除了不可变形式的实现，其他都支持null键和null值
		实现						键行为类似			值行为类似
		ArrayListMultimap		HashMap			ArrayList
		HashMultimap			HashMap			HashSet
		LinkedListMultimap*		LinkedHashMap*	LinkedList*
		LinkedHashMultimap**	LinkedHashMap	LinkedHashMap
		TreeMultimap			TreeMap			TreeSet
		ImmutableListMultimap	ImmutableMap	ImmutableList
		ImmutableSetMultimap	ImmutableMap	ImmutableSet
 * BiMap的各种实现
		键–值实现			值–键实现			对应的BiMap实现
		HashMap			HashMap			HashBiMap
		ImmutableMap	ImmutableMap	ImmutableBiMap
		EnumMap			EnumMap			EnumBiMap
		EnumMap			HashMap			EnumHashBiMap
 * Table有如下几种实现：
		HashBasedTable：本质上用HashMap<R, HashMap<C, V>>实现；
		TreeBasedTable：本质上用TreeMap<R, TreeMap<C,V>>实现；
		ImmutableTable：本质上用ImmutableMap<R, ImmutableMap<C, V>>实现；注：ImmutableTable对稀疏或密集的数据集都有优化。
		ArrayTable：要求在构造时就指定行和列的大小，本质上由一个二维数组实现，以提升访问速度和密集Table的内存利用率。ArrayTable与其他Table的工作原理有点不同，请参见Javadoc了解详情。
 * @author lliang
 *
 */
public class NewCollectionsTest {

	public static void main(String[] args) {
		multisetTest();
		multimapTest();
		biMapTest();
		tableTest();
		otherTest();
	}
	
	public static void multisetTest(){
		// 统计一个词在文档中出现的次数，传统做法
		List<String> words = Lists.newArrayList();
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String word : words) {
		    Integer count = counts.get(word);
		    if (count == null) {
		        counts.put(word, 1);
		    } else {
		        counts.put(word, count + 1);
		    }
		}
		// Multiset：”集合[set]概念的延伸，它的元素可以重复出现…与集合[set]相同而与元组[tuple]相反的是，Multiset元素的顺序是无关紧要的：Multiset {a, a, b}和{a, b, a}是相等的”。——译者注：这里所说的集合[set]是数学上的概念，Multiset继承自JDK中的Collection接口，而不是Set接口，所以包含重复元素并没有违反原有的接口契约。
		// 可以用两种方式看待Multiset：
		// 	1.没有元素顺序的ArrayList<E>：add(E)添加元素；iterator()返回迭代器，所有元素包含重复；size()返回元素个数
		// 	2.Map<E,Integer>，键为元素，值为计数：count(Object)返回给定元素的计数；entrySet()返回Set<Multiset.Entry<E>>和map的keySet()类似；elementSet()返回所有不重复元素Set<E>和map的keySet()类似
		// TreeMultiset在判断元素是否相等时，与TreeSet一样用compare，而不是Object.equals。另外特别注意，Multiset.addAll(Collection)可以添加Collection中的所有元素并进行计数，这比用for循环往Map添加元素和计数方便多了
		
		
		Multiset<String> hm = HashMultiset.create();
		hm.setCount("12", 2);
		hm.setCount("12", 2, 4);
		hm.remove("12");
		System.out.println(hm.size());
		
		// Multiset和map的区别
		// 	Multiset中的元素计数只能是正整数
		// 	size()方法返回集合的大小，计数的总和，如果要不重复的元素个数，使用elementSet().size()
		//  iterator()会迭代重复元素，因此长度为size()
		//  setCount(element, 0)等于移除element
		
		SortedMultiset<Integer> sm = ImmutableSortedMultiset.of(12);
		sm.subMultiset(0, BoundType.CLOSED, 100, BoundType.OPEN);
		// SortedMultiset:是Multiset 接口的变种，它支持高效地获取指定范围的子集
		// TreeMultiset实现SortedMultiset接口
	}

	public static void multimapTest(){
		// 	可以用两种方式思考Multimap的概念：”键-单个值映射”的集合Multimap：a -> 1 a -> 2 a ->4 b -> 3 c -> 5
		//	或者”键-值集合映射”的映射map.asMap()：a -> [1, 2, 4] b -> 3 c -> 5
//		方法签名							描述											等价于
//		put(K, V)						添加键到单个值的映射								multimap.get(key).add(value)
//		putAll(K, Iterable<V>)			依次添加键到多个值的映射							Iterables.addAll(multimap.get(key), values)
//		remove(K, V)					移除键到值的映射；如果有这样的键值并成功移除，返回true。		multimap.get(key).remove(value)
//		removeAll(K)					清除键对应的所有值，返回的集合包含所有之前映射到K的值，但修改这个集合就不会影响Multimap了。		multimap.get(key).clear()
//		replaceValues(K, Iterable<V>)	清除键对应的所有值，并重新把key关联到Iterable中的每个元素。返回的集合包含所有之前映射到K的值。	multimap.get(key).clear(); Iterables.addAll(multimap.get(key), values)
		
		// Multimap与map的区别
		// entries()返回所有“键-单个值映射”，包括重复键，如果要得到“键-值集合映射”，使用asMap().entrySet()
		// size()返回“键-单个值映射”的个数，如果要得到“键-值集合映射”的个数，使用keySet().size()
		// 
		
		Multimap<String, String> mapList = ArrayListMultimap.create();
		HashMultimap<String, String> mapSet = HashMultimap.create();
		Map<String, Collection<String>> mapL = mapList.asMap();
		Set<String> set = mapSet.get("12");
	}
	
	public static void biMapTest(){
		BiMap<String, Integer> strToInt = HashBiMap.create();
		strToInt.put("1", 1);
		strToInt.put("2", 2);
		strToInt.put("3", 3); // 被覆盖掉
		strToInt.put("3", 4);
		strToInt.forcePut("3", 5);
//		strToInt.put("4", 3); 调用inverse会报异常， 因为key不能有两个3
		BiMap<Integer, String> intToStr = strToInt.inverse();
		System.out.println(strToInt.get("3"));
		System.out.println(strToInt.size());
		System.out.println(intToStr.size());
	}
	
	public static void tableTest(){
		Table<Integer, Integer, String> t = HashBasedTable.create();
		t.put(1, 1, "1");
		t.put(2, 2, "4");
		Map<Integer, Map<Integer, String>> allRowMap = t.rowMap();
		Map<Integer, String> singleRowMap = t.row(1);
		Set<Cell<Integer, Integer, String>> cellSet = t.cellSet();
		System.out.println(cellSet.size());
		for(Cell<Integer, Integer, String> c : cellSet){
			System.out.println("cell==="+c.getRowKey());
			System.out.println("cell==="+c.getColumnKey());
			System.out.println("cell==="+c.getValue());
		}
//		rowMap()：用Map<R, Map<C, V>>表现Table<R, C, V>。同样的， rowKeySet()返回”行”的集合Set<R>。
//		row(r) ：用Map<C, V>返回给定”行”的所有列，对这个map进行的写操作也将写入Table中。
//		类似的列访问方法：columnMap()、columnKeySet()、column(c)。（基于列的访问会比基于的行访问稍微低效点）
//		cellSet()：用元素类型为Table.Cell<R, C, V>的Set表现Table<R, C, V>。Cell类似于Map.Entry，但它是用行和列两个键区分的。
	}
	
	public static void otherTest(){
		// ClassToInstanceMap类型指向实例的map，两种实现，一种可变一种不可变
		ClassToInstanceMap<Integer> m = MutableClassToInstanceMap.create();
		ClassToInstanceMap<Integer> i = ImmutableClassToInstanceMap.<Integer>builder().put(Integer.class, 3).build();
		m.put(Integer.class, 1);
		m.put(Integer.class, 2);
		m.putInstance(Integer.class, 2);
		int a = m.get(Integer.class);
		System.out.println(a);
//		i.put(Integer.class, 3); // 不可操作
		System.out.println(i.get(Integer.class));
		ClassToInstanceMap<Integer> i2 = ImmutableClassToInstanceMap.copyOf(m);
		int b = i2.get(Integer.class);
		System.out.println(b);
		
		// RangeSet
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 10)); // {[1,10]}
		rangeSet.add(Range.closedOpen(11, 15));//不相连区间:{[1,10], [11,15)}
		rangeSet.add(Range.closedOpen(15, 20)); //相连区间; {[1,10], [11,20)}
		rangeSet.add(Range.openClosed(0, 0)); //空区间; {[1,10], [11,20)}
		rangeSet.remove(Range.open(5, 10)); //分割[1, 10]; {[1,5], [10,10], [11,20)}
		// 视图
		RangeSet<Integer> complementSet = rangeSet.complement();//返回补集
		Range<Integer> r = Range.all();
		RangeSet<Integer> intersectionSet = rangeSet.subRangeSet(r);//交集
		Set<Range<Integer>> set = rangeSet.asRanges();// 返回set集合（仅ImmutableRangeSet支持，这个操作不支持DiscreteDomain 和RangeSet都没有上边界，或都没有下边界的情况）
		// 查询方法
		boolean isContains = rangeSet.contains(1);// 是否包含
		Range<Integer> containsRange = rangeSet.rangeContaining(1);// 返回包含指定元素的区间
		boolean isCloses = rangeSet.encloses(containsRange);// 判断rangeSet中是否有任何区间包含给定区间
		Range<Integer> min = rangeSet.span();// 返回最小区间
		// RangeMap：”不相交的、非空的区间”到特定值的映射
		RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
		rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
		rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
		rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}
		// rangeMap视图
		Map<Range<Integer>, String> map = rangeMap.asMapOfRanges();// map视图
		RangeMap<Integer, String> complementMap = rangeMap.subRangeMap(containsRange);// 交集
	}
	
	
	
}
