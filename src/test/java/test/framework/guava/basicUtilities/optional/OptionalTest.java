package test.framework.guava.basicUtilities.optional;

import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/**
 * guava 1.1-ʹ�úͱ���null
 * ʹ��Optional���˸���null���壬�����˿ɶ��ԣ�������ʽ�ش�Optional��ȡ����
 * 
 * @author lliang
 *
 */
public class OptionalTest {
	
	public static void main(String[] args) {
		Optional<Integer> o = Optional.of(5);
//		o = Optional.absent();// ��������ȱʧ��ʵ��
//		Optional<String> os = Optional.fromNullable(null);// ����ָ�����õ�Optionalʵ����������Ϊnull���ʾȱʧ
		System.out.println(o.isPresent()); // ���Optional������null�����ã����ô��ڣ�������true
		System.out.println(o.get()); // ����Optional�����������ã�������ȱʧ�����׳�java.lang.IllegalStateException
		System.out.println(o.or(1)); // ����Optional�����������ã�������ȱʧ������ָ����ֵ
		System.out.println(o.orNull()); // ����Optional�����������ã�������ȱʧ������null
		Set<Integer> s = o.asSet();
		System.out.println(s.size());
		
		// Ҳ����ʹ�����·�������nullֵ
		@SuppressWarnings("deprecation")
		Integer ss = Objects.firstNonNull(null, 2);
		System.out.println(ss);
	}

}
