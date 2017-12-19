package test.java.multiThread.deadThread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 死锁，尽量避免互相持有对方的锁（各自占用对方需要的锁，导致程序一直阻塞）
 * @author lliang
 *
 */
public class DeadThread implements Runnable {
	
	
	public String username;
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	
	public void setFlag(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		if("a".equals(username)) {
			synchronized (lock1) {
				try {
					System.out.println("username = "+username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("按lock1-》lock2代码顺序执行了");
				}
			}
		}
		if("b".equals(username)) {
			synchronized (lock2) {
				try {
					System.out.println("username = "+username);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("按lock2-》lock1代码顺序执行了");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		AtomicBoolean locked = new AtomicBoolean(true);
		boolean b =  locked.compareAndSet(false, true);
		System.out.println(b);
		
		AtomicInteger ai = new AtomicInteger(10);
		boolean aib =  ai.compareAndSet(10, 5);
		System.out.println(aib);
		System.out.println(ai.toString());
		
//		DeadThread t1 = new DeadThread();
//		t1.setFlag("a");
//		Thread thread1 = new Thread(t1);
//		thread1.start();
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		t1.setFlag("b");
//		Thread thread2 = new Thread(t1);
//		thread2.start();
	}

}
