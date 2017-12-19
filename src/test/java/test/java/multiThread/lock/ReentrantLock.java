package test.java.multiThread.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 重入锁
 * 
 * @author lliang
 *
 */
public class ReentrantLock {
	
	public java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
	
	// 参数true表示创建公平锁，false创建非公平锁，默认是非公平锁
	Lock fairLock = new java.util.concurrent.locks.ReentrantLock(true);
	
	public void test() throws InterruptedException{
		
		// Lock接口的方法
		// 获取锁，如果对象上有锁，等待锁释放
		lock.lock();
		// 释放锁
		lock.unlock();
		// 仅在调用时，锁未被占用时，才获取锁
		lock.tryLock();
		// 在给定时间内尝试获取锁
		lock.tryLock(1, TimeUnit.SECONDS);
		// 如果当前线程未被中断，则获取该锁，如果被中断出现异常
		lock.lockInterruptibly();
		// 返回与lock实例一起使用的condition
		Condition condition = lock.newCondition();
		
		// condition
		// 让当前线程在接到信号（signal）或被中断之前一直处于等待状态（释放对象锁）
		condition.await();
		condition.await(1, TimeUnit.SECONDS);
		// 唤醒该condition上的一个/全部等待线程
		condition.signal();
		condition.signalAll();
		// 让线程等待给定的时间（单位：微毫秒）
		condition.awaitNanos(1);
		// 让当前线程在接收信号之前一直处于等待状态（线程中断也等待）
		condition.awaitUninterruptibly();
		// 线程等待到指定时间（线程在等在的时间内，可以被其他线程提前唤醒）
		condition.awaitUntil(new Date());
		
		// ReentrantLock实现类的自有方法
		// 查询当前线程保持此锁的次数（调用lock()方法的次数）
		int holdCount = lock.getHoldCount();
		// 查询正在等待获取锁的线程数
		lock.getQueueLength();
		// 查询等待与此锁定相关的条件condition的线程数
		lock.getWaitQueueLength(condition);
		// 查询指定线程，是否正在等待获取此锁定
		lock.hasQueuedThread(new Thread());
		// 是否有线程等待此锁定
		lock.hasQueuedThreads();
		// 是否有线程正在等待与此锁定有关的condition条件
		lock.hasWaiters(condition);
		// 是否是公平锁、默认是非公平锁
		lock.isFair();
		// 查询当前线程是否占有此锁
		lock.isHeldByCurrentThread();
		// 查询此锁是否被（任意线程）占有
		lock.isLocked();
	}
}
