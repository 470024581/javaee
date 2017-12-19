package test.framework.guava.rateLimiter;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 接口限流方案
 * @author lliang
 *
 */
public class RateLimiterTest {

	// 创建令牌桶，没有往桶里扔一个令牌，令牌的有效期是1秒，不会堆积
	static final RateLimiter rateLimiter = RateLimiter.create(2, 5, TimeUnit.SECONDS);//(1);
	
	public static void submitPacket() {
		System.out.println("getRate()===" + rateLimiter.getRate());
		// 尝试获取令牌（不会消耗令牌）
		if(rateLimiter.tryAcquire()){
			// 获取2个令牌
			System.out.println(Thread.currentThread().getName() + "===" + System.currentTimeMillis());
			rateLimiter.acquire(2);
			System.out.println(Thread.currentThread().getName() + "===" + System.currentTimeMillis());
		} else {
			// 获取一个令牌
			System.out.println(Thread.currentThread().getName() + "绕过了===" + System.currentTimeMillis());
			rateLimiter.acquire();
			System.out.println(Thread.currentThread().getName() + "绕过了===" + System.currentTimeMillis());
		}
//		rateLimiter.acquire();
	}

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(10000);
		Thread a = new Thread("a"){
			@Override
			public void run(){
				submitPacket();
			}
		};
		Thread b = new Thread("b"){
			@Override
			public void run(){
				submitPacket();
			}
		};
		Thread c = new Thread("c"){
			@Override
			public void run(){
				submitPacket();
			}
		};
		Thread d = new Thread("d"){
			@Override
			public void run(){
				submitPacket();
			}
		};
		Thread e = new Thread("e"){
			@Override
			public void run(){
				submitPacket();
			}
		};
		Thread f = new Thread("f"){
			@Override
			public void run(){
				submitPacket();
			}
		};
		a.start();
		b.start();
		c.start();
		d.start();
		e.start();
		f.start();
	}

}
