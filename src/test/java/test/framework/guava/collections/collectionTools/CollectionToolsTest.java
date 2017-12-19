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
 * guava 2.3-���Ϲ�����
 * 	���������ֱ�۵ķ�ʽ�ѹ��������ض����ϽӿڵĶ�Ӧ��ϵ�������£�
	���Ͻӿ�		����JDK����Guava	��Ӧ��Guava������
	Collection	JDK				Collections2����Ҫ��java.util.Collections����
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
		// ������̬����
		// �����ظ��������ͣ��ҿ���ֱ��ָ��ֵ���߳���
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
		List<List<String>> subList = Lists.partition(list, 1);// ��ָ����С�ָ���2��List
		System.out.println(subList.size());// 2
		List<String> reverseList = Lists.reverse(list);// ˳�򵹹�����List
		// ����ʵ������		��������
//		ArrayList		basic, with elements, from Iterable, with exact capacity, with expected size, from Iterator
//		LinkedList		basic, from Iterable
		
		// Sets 
		Set<String> set = Sets.newHashSet("1","2","3","5");
		Set<String> set1 = Sets.newHashSet("2","3","4");
		SetView<String> sv = Sets.union(set, set);// ȫ��
		Sets.intersection(set, set);// ����
		Sets.difference(set, set1);//[1,5]  ����set���Ԫ��û����set1�г��ֵ�Ԫ�ؼ���
		Sets.symmetricDifference(set1, set);//[4,1,5]  ���ز��ظ�����
		sv.copyInto(set);// ���ظ��ƶ���
		ImmutableSet<String> is = sv.immutableCopy();// �����Լ��Ĳ��ɱ临�ƶ���
		Sets.cartesianProduct(set, set1);// {{1,2},{1,3},{1,4},{2,2}...} �������м��ϵĵѿ�����������Ԫ�طֱ������Ԫ����ϣ�
		Sets.powerSet(set1);// {{},{1}...} ����ָ�����ϵ������Ӽ�
//		����ʵ������		��������
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
		    }); // {1:"1",2:"23"} �������ֶγ���Ϊkey��Ԫ��Ϊvalue��map���������ͬ�����ԣ��ᱨ����ʹ��Multimaps.index������
		Map<Integer, String> mapIs = Maps.newHashMap();
		mapIs.put(1, "2");
		mapIs.put(2, "23");
		mapIs.put(3, "3");
		mapIs.put(4, "4");
		MapDifference<Integer, String> md = Maps.difference(mapIs, stringsByIndex);// 
		Map<Integer, String> common = md.entriesInCommon();//{2=23} ��ֵ����ͬ��Ԫ�ؼ���
		Map<Integer, ValueDifference<String>> differing = md.entriesDiffering();//{1=(2, 1)} ����ͬ��ֵ��ͬ
		Map<Integer, String> left = md.entriesOnlyOnLeft();// {3=3, 4=4} ���map���У�key�����ұ�û�е�Ԫ�ؼ���
		Map<Integer, String> right =  md.entriesOnlyOnRight();// {} �ұ��У����û��
		
		// Iterables
//		���淽��
//		concat(Iterable<Iterable>)			�������iterables������ͼ*								concat(Iterable...)
//		frequency(Iterable, Object)			���ض�����iterable�г��ֵĴ���								��Collections.frequency (Collection,   Object)�Ƚ�;Multiset
//		partition(Iterable, int)			��iterable��ָ����С�ָ�õ����Ӽ������ܽ����޸Ĳ���				Lists.partition(List, int);paddedPartition(Iterable, int)
//		getFirst(Iterable, T default)		����iterable�ĵ�һ��Ԫ�أ���iterableΪ���򷵻�Ĭ��ֵ			��Iterable.iterator(). next()�Ƚ�;FluentIterable.first()
//		getLast(Iterable)					����iterable�����һ��Ԫ�أ���iterableΪ�����׳�NoSuchElementException		getLast(Iterable, T default);FluentIterable.last()
//		elementsEqual(Iterable, Iterable)	�������iterable�е�����Ԫ�������˳��һ�£�����true				��List.equals(Object)�Ƚ�
//		unmodifiableIterable(Iterable)		����iterable�Ĳ��ɱ���ͼ									��Collections.unmodifiableCollection(Collection)�Ƚ�
//		limit(Iterable, int)				����iterable��Ԫ�ظ������Ƹ���ֵ							FluentIterable.limit(int)
//		getOnlyElement(Iterable)			��ȡiterable��Ψһ��Ԫ�أ����iterableΪ�ջ��ж��Ԫ�أ������ʧ��	getOnlyElement(Iterable, T default)
		
	}


}
