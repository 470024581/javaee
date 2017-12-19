package test.framework.guava.collections.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * guava 2.1-���ɱ伯��
 * ���ɱ�����кܶ��ŵ㣬��������������nullֵ��
		�����󱻲����ŵĿ����ʱ�����ɱ���ʽ�ǰ�ȫ�ģ�
		���ɱ���󱻶���̵߳���ʱ�������ھ�̬��������
		���ɱ伯�ϲ���Ҫ���Ǳ仯����˿��Խ�ʡʱ��Ϳռ䡣���в��ɱ�ļ��϶������ǵĿɱ���ʽ�и��õ��ڴ������ʣ������Ͳ���ϸ�ڣ���
		���ɱ������Ϊ�й̶����䣬������Ϊ��������ȫʹ�á�
   JDKҲ�ṩ��Collections.unmodifiableXXX�����Ѽ��ϰ�װΪ���ɱ���ʽ����������Ϊ�����ã�
		���ض�����׸���������ʵ������������������Կ����ĳ�����
		����ȫ��Ҫ��֤û��ͨ��ԭ���ϵ����ý����޸ģ����صļ��ϲ�����ʵ�ϲ��ɱ�ģ�
		��Ч����װ���ļ�����Ȼ���пɱ伯�ϵĿ��������粢���޸ĵļ�顢ɢ�б�Ķ���ռ䣬�ȵȡ�	
 * @author lliang
 *
 */
public class ImmutableTest {

	public static void main(String[] args) {
		// ���ɱ伯�ϵĴ���
		ImmutableSet<String> SET = ImmutableSet.of("123", "456");
		ImmutableSet<String> COPY_SET = ImmutableSet.copyOf(SET);
		ImmutableSet<String> BUILD_SET = ImmutableSet.<String>builder().add("234").addAll(COPY_SET).build();
		
		// ���еĲ��ɱ伯�϶�ӵ��asList������
		ImmutableList<String> iList = BUILD_SET.asList();
		
//		ϸ�ڣ������ɱ伯�ϺͲ��ɱ伯��
//		�ɱ伯�Ͻӿ�		����JDK����Guava	���ɱ�汾
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
