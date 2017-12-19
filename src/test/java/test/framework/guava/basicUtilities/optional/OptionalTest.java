package test.framework.guava.basicUtilities.optional;

import java.util.Set;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

/**
 * guava 1.1-使用和避免null
 * 使用Optional除了赋予null语义，增加了可读性，必须显式地从Optional获取引用
 * 
 * @author lliang
 *
 */
public class OptionalTest {
	
	public static void main(String[] args) {
		Optional<Integer> o = Optional.of(5);
//		o = Optional.absent();// 创建引用缺失的实例
//		Optional<String> os = Optional.fromNullable(null);// 创建指定引用的Optional实例，若引用为null则表示缺失
		System.out.println(o.isPresent()); // 如果Optional包含非null的引用（引用存在），返回true
		System.out.println(o.get()); // 返回Optional所包含的引用，若引用缺失，则抛出java.lang.IllegalStateException
		System.out.println(o.or(1)); // 返回Optional所包含的引用，若引用缺失，返回指定的值
		System.out.println(o.orNull()); // 返回Optional所包含的引用，若引用缺失，返回null
		Set<Integer> s = o.asSet();
		System.out.println(s.size());
		
		// 也可以使用以下方法代替null值
		@SuppressWarnings("deprecation")
		Integer ss = Objects.firstNonNull(null, 2);
		System.out.println(ss);
	}

}
