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
 * guava 3 锟斤拷锟斤拷
 * 
 * 
 * 
 * @author lliang
 *
 */
public class CachesTest {
	
	public static void main(String[] args) throws ExecutionException {
		
		RemovalListener<String, Integer> removalListener = new RemovalListener<String, Integer>() {
			    public void onRemoval(RemovalNotification<String, Integer> removal) {
			    	System.out.println(removal.getKey()+"==="+removal.getValue());
			    }
			};
		LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
		        .expireAfterWrite(10, TimeUnit.MINUTES)
		        .removalListener(removalListener)
		        .build(new CacheLoader<String, Integer>(){
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
