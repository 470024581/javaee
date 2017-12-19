package test.framework.guava.rateLimiter;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * �ӿ���������
 * @author lliang
 *
 */
public class RateLimiterTest {

	// ��������Ͱ��û����Ͱ����һ�����ƣ����Ƶ���Ч����1�룬����ѻ�
	static final RateLimiter rateLimiter = RateLimiter.create(2, 5, TimeUnit.SECONDS);//(1);
	
	public static void submitPacket() {
		System.out.println("getRate()===" + rateLimiter.getRate());
		// ���Ի�ȡ���ƣ������������ƣ�
		if(rateLimiter.tryAcquire()){
			// ��ȡ2������
			System.out.println(Thread.currentThread().getName() + "===" + System.currentTimeMillis());
			rateLimiter.acquire(2);
			System.out.println(Thread.currentThread().getName() + "===" + System.currentTimeMillis());
		} else {
			// ��ȡһ������
			System.out.println(Thread.currentThread().getName() + "�ƹ���===" + System.currentTimeMillis());
			rateLimiter.acquire();
			System.out.println(Thread.currentThread().getName() + "�ƹ���===" + System.currentTimeMillis());
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
