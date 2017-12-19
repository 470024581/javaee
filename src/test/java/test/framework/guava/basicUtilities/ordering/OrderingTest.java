package test.framework.guava.basicUtilities.ordering;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * guava 1.4-������ Guava��ʽ���Ƚ���[Comparator]��ʵ�֣�����������Ϊ�������ӵıȽ���������ɼ�������Ĺ��ܡ�
 * 
 * @author lliang
 * 
 */
public class OrderingTest implements Comparable<OrderingTest> {
	
	private String sortby;

	public static void main(String[] args) {
		// ����������
		Ordering<OrderingTest> order = Ordering.natural();// �Կ�������������Ȼ���������ְ���С�����ڰ��Ⱥ�����
		Ordering<Object> o = Ordering.usingToString();// ������ ���ַ�����ʽ���ֵ�����
		Ordering.from(o);// �Ѹ�����Comparatorת��Ϊ������
		// ʵ���Զ���������������from������Ҳ����ֱ�Ӽ̳�Ordering:
		Ordering<String> byLengthOrdering = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};
		
		// ��ʽ���÷����������ɸ�����������������������������
		order.reverse();// ��ȡ�����෴��������
		order.nullsFirst();// ʹ�õ�ǰ���������������nullֵ�ŵ���ǰ��
		order.nullsLast();// ʹ�õ�ǰ���������������nullֵ�ŵ������
		order.compound(o);// �ϳ�һ���Ƚ������Դ���ǰ�������е�������
		Ordering<Iterable<OrderingTest>> it = order.lexicographical(); // ���ڴ�������T�������������ظ����͵Ŀɵ�������Iterable<T>��������
		Ordering.natural().onResultOf(new Function<OrderingTest, String>(){
			@Override
			public String apply(OrderingTest input) {
				return input.sortby;
			}
		}); // �Լ�����Ԫ�ص���Function���ٰ�����ֵ�õ�ǰ����������
		
//		���Ķ���ʽ���ò�����������ʱ��Ӧ�ôӺ���ǰ��������������У����������ȵ���apply������ȡsortedByֵ������sortedByΪnull��Ԫ�ض��ŵ���ǰ�棬Ȼ���ʣ�µ�Ԫ�ذ�sortedBy������Ȼ����֮����Ҫ�Ӻ���ǰ��������Ϊÿ����ʽ���ö����ú���ķ�����װ��ǰ�����������
//		ע����compound������װ������ʱ���Ͳ�Ӧ��ѭ�Ӻ���ǰ����ԭ��Ϊ�˱�������ϵĻ��ң��벻Ҫ��compoundд��һ������ʽ���õ��м䣬���������һ�У����������Ȼ�������compound��
//		����һ�����ȵ���ʽ���ã�Ҳ���ܻ�����Ķ�������ϵ��Ѷȡ����ǽ��鰴����Ĵ�����������һ���������ʹ���������������⣬��Ҳ���԰�Function������м��������ʽ���ø������ա�
		
		// ����������
//		o.greatestOf(Iterable iterable, int k)  ��ȡ�ɵ�������������k��Ԫ��					leastOf(), greatestOf(Iterator iterator, int k)
//		isOrdered(Iterable)		�жϿɵ��������Ƿ��Ѱ���������������������ֵ��ȵ�Ԫ�ء�				isStrictlyOrdered
//		sortedCopy(Iterable)	�жϿɵ��������Ƿ����ϸ����������򣺲���������ֵ��ȵ�Ԫ�ء�			immutableSortedCopy
//		min(E, E)				����������������С���Ǹ��������ȣ��򷵻ص�һ��������				max(E, E)
//		min(E, E, E, E...)		���ض����������С���Ǹ�������г���һ����������С���򷵻ص�һ����С�Ĳ�����	max(E, E, E, E...)
//		min(Iterable)			���ص���������С��Ԫ�ء�����ɵ���������û��Ԫ�أ����׳�NoSuchElementException��	max(Iterable), min(Iterator), max(Iterator)
	
	}

	@Override
	public int compareTo(OrderingTest o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


