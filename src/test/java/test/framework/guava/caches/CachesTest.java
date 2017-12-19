package test.framework.guava.caches;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * guava 3 ����
 * 
 * 
 * 
 * @author lliang
 *
 */
public class CachesTest {
	
	public static void main(String[] args) throws ExecutionException {
		// �����������գ����潫���Ի������û��ʹ�û������Ϻ���ʹ�õĻ�����������棺�ڻ��������Ŀ�ﵽ�޶�ֵ֮ǰ������Ϳ��ܽ��л��ղ�������ͨ����˵��������������ڻ��������Ŀ�ƽ��޶�ֵʱ��
		// ��ʱ���գ�expireAfterAccess(long, TimeUnit)���������ڸ�ʱ����û�б���/д���ʣ�����ա���ע�����ֻ���Ļ���˳��ͻ��ڴ�С����һ��
		// 		 expireAfterWrite(long, TimeUnit)���������ڸ�ʱ����û�б�д���ʣ������򸲸ǣ�������ա�
		// �������õĻ��գ�CacheBuilder.weakKeys()��ʹ�������ô洢���û������ǿ���?����ʱ����������Ա�������ա���Ϊ������ս��������ʽ��==����ʹ�������ü�Ļ�����==����equals�Ƚϼ�
//					CacheBuilder.weakValues()��ʹ�������ô洢ֵ����ֵû������ǿ���?����ʱ����������Ա�������ա���Ϊ������ս��������ʽ��==����ʹ��������ֵ�Ļ�����==����equals�Ƚ�ֵ��
//					CacheBuilder.softValues()��ʹ�������ô洢ֵ��������ֻ������Ӧ�ڴ���Ҫʱ���Ű���ȫ���������ʹ�õ�˳����ա����ǵ�ʹ�������õ�����Ӱ�죬����ͨ������ʹ�ø�������Ԥ���ԵĻ����С�޶��������ģ������������գ���ʹ��������ֵ�Ļ���ͬ����==����equals�Ƚ�ֵ��
		// ��ʾ���������Cache.invalidate(key)
//					�������Cache.invalidateAll(keys)
//					������л����Cache.invalidateAll()
		// �Ƴ�ʱ��������removalListener(removalListener)
		// 
		// ͳ��
		
		RemovalListener<String, Integer> removalListener = new RemovalListener<String, Integer>() {
			    public void onRemoval(RemovalNotification<String, Integer> removal) {
			    	System.out.println("����ļ�ֵ��ɾ��");
			    	System.out.println(removal.getKey()+"==="+removal.getValue());
			    }
			};
		LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)// ��󲻿ɱ䳤��1000
		        .expireAfterWrite(10, TimeUnit.MINUTES)// ����ʱ��10����
		        .removalListener(removalListener)// ���ɾ��ʱ�ļ�����
		        .build(new CacheLoader<String, Integer>(){// ʵ��load����������key������value
				    @Override
					public Integer load(String str){
						return Integer.valueOf(str);
					}
				});
		cache.put("1", 1);
		final String key = "1";
		cache.get(key, new Callable<Integer>(){
			@Override
			public Integer call() throws Exception {
				return Integer.valueOf(key);
			}
		});
		
		// 
	}

}
