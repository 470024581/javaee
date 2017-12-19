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
 * guava 2.2-�¼�������
 * 
 * Muitiset�������list���Զ��������ظ���set
 * SortedMultiset����������ȣ�����
 * Multimap����ӳ�䵥��ֵ�ͼ���ֵ��set
 * BiMap����ֵ�����໥ת��ӳ�������map��������ͬ��value����ת����keyʱ����ΪkeyҪΨһ���ᱨ�쳣��
 * Table��ӵ����������֧���������͵ļ����к��С��ṩ������ͼ�Ա�Ӹ��ֽǶ�ʹ��
 * ClassToInstanceMap������ӳ��ʵ��
 * RangeSet�����伯��
 * RangeMap�������ཻ�ġ��ǿյ����䡱���ض�ֵ��ӳ��
 * 
 * Multiset��ʵ�֣����¶�ӦJDK��Map�ĸ���ʵ�֣�
		Map					��Ӧ��Multiset			�Ƿ�֧��nullԪ��
		HashMap				HashMultiset			��
		TreeMap				TreeMultiset			�ǣ����comparator֧�ֵĻ���
		LinkedHashMap		LinkedHashMultiset		��
		ConcurrentHashMap	ConcurrentHashMultiset	��
		ImmutableMap		ImmutableMultiset		��
 * Multimap��ʵ�֡��ڴ����Ҫʹ��Map<K, Collection<V>>�ĵط����㶼����ʹ�����ǣ�
  	���˲��ɱ���ʽ��ʵ�֣�������֧��null����nullֵ
		ʵ��						����Ϊ����			ֵ��Ϊ����
		ArrayListMultimap		HashMap			ArrayList
		HashMultimap			HashMap			HashSet
		LinkedListMultimap*		LinkedHashMap*	LinkedList*
		LinkedHashMultimap**	LinkedHashMap	LinkedHashMap
		TreeMultimap			TreeMap			TreeSet
		ImmutableListMultimap	ImmutableMap	ImmutableList
		ImmutableSetMultimap	ImmutableMap	ImmutableSet
 * BiMap�ĸ���ʵ��
		���Cֵʵ��			ֵ�C��ʵ��			��Ӧ��BiMapʵ��
		HashMap			HashMap			HashBiMap
		ImmutableMap	ImmutableMap	ImmutableBiMap
		EnumMap			EnumMap			EnumBiMap
		EnumMap			HashMap			EnumHashBiMap
 * Table�����¼���ʵ�֣�
		HashBasedTable����������HashMap<R, HashMap<C, V>>ʵ�֣�
		TreeBasedTable����������TreeMap<R, TreeMap<C,V>>ʵ�֣�
		ImmutableTable����������ImmutableMap<R, ImmutableMap<C, V>>ʵ�֣�ע��ImmutableTable��ϡ����ܼ������ݼ������Ż���
		ArrayTable��Ҫ���ڹ���ʱ��ָ���к��еĴ�С����������һ����ά����ʵ�֣������������ٶȺ��ܼ�Table���ڴ������ʡ�ArrayTable������Table�Ĺ���ԭ���е㲻ͬ����μ�Javadoc�˽����顣
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
		// ͳ��һ�������ĵ��г��ֵĴ�������ͳ����
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
		// Multiset��������[set]��������죬����Ԫ�ؿ����ظ����֡��뼯��[set]��ͬ����Ԫ��[tuple]�෴���ǣ�MultisetԪ�ص�˳�����޹ؽ�Ҫ�ģ�Multiset {a, a, b}��{a, b, a}����ȵġ�����������ע��������˵�ļ���[set]����ѧ�ϵĸ��Multiset�̳���JDK�е�Collection�ӿڣ�������Set�ӿڣ����԰����ظ�Ԫ�ز�û��Υ��ԭ�еĽӿ���Լ��
		// ���������ַ�ʽ����Multiset��
		// 	1.û��Ԫ��˳���ArrayList<E>��add(E)���Ԫ�أ�iterator()���ص�����������Ԫ�ذ����ظ���size()����Ԫ�ظ���
		// 	2.Map<E,Integer>����ΪԪ�أ�ֵΪ������count(Object)���ظ���Ԫ�صļ�����entrySet()����Set<Multiset.Entry<E>>��map��keySet()���ƣ�elementSet()�������в��ظ�Ԫ��Set<E>��map��keySet()����
		// TreeMultiset���ж�Ԫ���Ƿ����ʱ����TreeSetһ����compare��������Object.equals�������ر�ע�⣬Multiset.addAll(Collection)�������Collection�е�����Ԫ�ز����м����������forѭ����Map���Ԫ�غͼ����������
		
		
		Multiset<String> hm = HashMultiset.create();
		hm.setCount("12", 2);
		hm.setCount("12", 2, 4);
		hm.remove("12");
		System.out.println(hm.size());
		
		// Multiset��map������
		// 	Multiset�е�Ԫ�ؼ���ֻ����������
		// 	size()�������ؼ��ϵĴ�С���������ܺͣ����Ҫ���ظ���Ԫ�ظ�����ʹ��elementSet().size()
		//  iterator()������ظ�Ԫ�أ���˳���Ϊsize()
		//  setCount(element, 0)�����Ƴ�element
		
		SortedMultiset<Integer> sm = ImmutableSortedMultiset.of(12);
		sm.subMultiset(0, BoundType.CLOSED, 100, BoundType.OPEN);
		// SortedMultiset:��Multiset �ӿڵı��֣���֧�ָ�Ч�ػ�ȡָ����Χ���Ӽ�
		// TreeMultisetʵ��SortedMultiset�ӿ�
	}

	public static void multimapTest(){
		// 	���������ַ�ʽ˼��Multimap�ĸ������-����ֵӳ�䡱�ļ���Multimap��a -> 1 a -> 2 a ->4 b -> 3 c -> 5
		//	���ߡ���-ֵ����ӳ�䡱��ӳ��map.asMap()��a -> [1, 2, 4] b -> 3 c -> 5
//		����ǩ��							����											�ȼ���
//		put(K, V)						��Ӽ�������ֵ��ӳ��								multimap.get(key).add(value)
//		putAll(K, Iterable<V>)			������Ӽ������ֵ��ӳ��							Iterables.addAll(multimap.get(key), values)
//		remove(K, V)					�Ƴ�����ֵ��ӳ�䣻����������ļ�ֵ���ɹ��Ƴ�������true��		multimap.get(key).remove(value)
//		removeAll(K)					�������Ӧ������ֵ�����صļ��ϰ�������֮ǰӳ�䵽K��ֵ�����޸�������ϾͲ���Ӱ��Multimap�ˡ�		multimap.get(key).clear()
//		replaceValues(K, Iterable<V>)	�������Ӧ������ֵ�������°�key������Iterable�е�ÿ��Ԫ�ء����صļ��ϰ�������֮ǰӳ�䵽K��ֵ��	multimap.get(key).clear(); Iterables.addAll(multimap.get(key), values)
		
		// Multimap��map������
		// entries()�������С���-����ֵӳ�䡱�������ظ��������Ҫ�õ�����-ֵ����ӳ�䡱��ʹ��asMap().entrySet()
		// size()���ء���-����ֵӳ�䡱�ĸ��������Ҫ�õ�����-ֵ����ӳ�䡱�ĸ�����ʹ��keySet().size()
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
		strToInt.put("3", 3); // �����ǵ�
		strToInt.put("3", 4);
		strToInt.forcePut("3", 5);
//		strToInt.put("4", 3); ����inverse�ᱨ�쳣�� ��Ϊkey����������3
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
//		rowMap()����Map<R, Map<C, V>>����Table<R, C, V>��ͬ���ģ� rowKeySet()���ء��С��ļ���Set<R>��
//		row(r) ����Map<C, V>���ظ������С��������У������map���е�д����Ҳ��д��Table�С�
//		���Ƶ��з��ʷ�����columnMap()��columnKeySet()��column(c)���������еķ��ʻ�Ȼ��ڵ��з�����΢��Ч�㣩
//		cellSet()����Ԫ������ΪTable.Cell<R, C, V>��Set����Table<R, C, V>��Cell������Map.Entry�����������к������������ֵġ�
	}
	
	public static void otherTest(){
		// ClassToInstanceMap����ָ��ʵ����map������ʵ�֣�һ�ֿɱ�һ�ֲ��ɱ�
		ClassToInstanceMap<Integer> m = MutableClassToInstanceMap.create();
		ClassToInstanceMap<Integer> i = ImmutableClassToInstanceMap.<Integer>builder().put(Integer.class, 3).build();
		m.put(Integer.class, 1);
		m.put(Integer.class, 2);
		m.putInstance(Integer.class, 2);
		int a = m.get(Integer.class);
		System.out.println(a);
//		i.put(Integer.class, 3); // ���ɲ���
		System.out.println(i.get(Integer.class));
		ClassToInstanceMap<Integer> i2 = ImmutableClassToInstanceMap.copyOf(m);
		int b = i2.get(Integer.class);
		System.out.println(b);
		
		// RangeSet
		RangeSet<Integer> rangeSet = TreeRangeSet.create();
		rangeSet.add(Range.closed(1, 10)); // {[1,10]}
		rangeSet.add(Range.closedOpen(11, 15));//����������:{[1,10], [11,15)}
		rangeSet.add(Range.closedOpen(15, 20)); //��������; {[1,10], [11,20)}
		rangeSet.add(Range.openClosed(0, 0)); //������; {[1,10], [11,20)}
		rangeSet.remove(Range.open(5, 10)); //�ָ�[1, 10]; {[1,5], [10,10], [11,20)}
		// ��ͼ
		RangeSet<Integer> complementSet = rangeSet.complement();//���ز���
		Range<Integer> r = Range.all();
		RangeSet<Integer> intersectionSet = rangeSet.subRangeSet(r);//����
		Set<Range<Integer>> set = rangeSet.asRanges();// ����set���ϣ���ImmutableRangeSet֧�֣����������֧��DiscreteDomain ��RangeSet��û���ϱ߽磬��û���±߽�������
		// ��ѯ����
		boolean isContains = rangeSet.contains(1);// �Ƿ����
		Range<Integer> containsRange = rangeSet.rangeContaining(1);// ���ذ���ָ��Ԫ�ص�����
		boolean isCloses = rangeSet.encloses(containsRange);// �ж�rangeSet���Ƿ����κ����������������
		Range<Integer> min = rangeSet.span();// ������С����
		// RangeMap�������ཻ�ġ��ǿյ����䡱���ض�ֵ��ӳ��
		RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
		rangeMap.put(Range.closed(1, 10), "foo"); //{[1,10] => "foo"}
		rangeMap.put(Range.open(3, 6), "bar"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo"}
		rangeMap.put(Range.open(10, 20), "foo"); //{[1,3] => "foo", (3,6) => "bar", [6,10] => "foo", (10,20) => "foo"}
		rangeMap.remove(Range.closed(5, 11)); //{[1,3] => "foo", (3,5) => "bar", (11,20) => "foo"}
		// rangeMap��ͼ
		Map<Range<Integer>, String> map = rangeMap.asMapOfRanges();// map��ͼ
		RangeMap<Integer, String> complementMap = rangeMap.subRangeMap(containsRange);// ����
	}
	
	
	
}
