package test.java.multiThread.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * ������
 * 
 * @author lliang
 *
 */
public class ReentrantLock {
	
	public java.util.concurrent.locks.ReentrantLock lock = new java.util.concurrent.locks.ReentrantLock();
	
	// ����true��ʾ������ƽ����false�����ǹ�ƽ����Ĭ���Ƿǹ�ƽ��
	Lock fairLock = new java.util.concurrent.locks.ReentrantLock(true);
	
	public void test() throws InterruptedException{
		
		// Lock�ӿڵķ���
		// ��ȡ��������������������ȴ����ͷ�
		lock.lock();
		// �ͷ���
		lock.unlock();
		// ���ڵ���ʱ����δ��ռ��ʱ���Ż�ȡ��
		lock.tryLock();
		// �ڸ���ʱ���ڳ��Ի�ȡ��
		lock.tryLock(1, TimeUnit.SECONDS);
		// �����ǰ�߳�δ���жϣ����ȡ������������жϳ����쳣
		lock.lockInterruptibly();
		// ������lockʵ��һ��ʹ�õ�condition
		Condition condition = lock.newCondition();
		
		// condition
		// �õ�ǰ�߳��ڽӵ��źţ�signal�����ж�֮ǰһֱ���ڵȴ�״̬���ͷŶ�������
		condition.await();
		condition.await(1, TimeUnit.SECONDS);
		// ���Ѹ�condition�ϵ�һ��/ȫ���ȴ��߳�
		condition.signal();
		condition.signalAll();
		// ���̵߳ȴ�������ʱ�䣨��λ��΢���룩
		condition.awaitNanos(1);
		// �õ�ǰ�߳��ڽ����ź�֮ǰһֱ���ڵȴ�״̬���߳��ж�Ҳ�ȴ���
		condition.awaitUninterruptibly();
		// �̵߳ȴ���ָ��ʱ�䣨�߳��ڵ��ڵ�ʱ���ڣ����Ա������߳���ǰ���ѣ�
		condition.awaitUntil(new Date());
		
		// ReentrantLockʵ��������з���
		// ��ѯ��ǰ�̱߳��ִ����Ĵ���������lock()�����Ĵ�����
		int holdCount = lock.getHoldCount();
		// ��ѯ���ڵȴ���ȡ�����߳���
		lock.getQueueLength();
		// ��ѯ�ȴ����������ص�����condition���߳���
		lock.getWaitQueueLength(condition);
		// ��ѯָ���̣߳��Ƿ����ڵȴ���ȡ������
		lock.hasQueuedThread(new Thread());
		// �Ƿ����̵߳ȴ�������
		lock.hasQueuedThreads();
		// �Ƿ����߳����ڵȴ���������йص�condition����
		lock.hasWaiters(condition);
		// �Ƿ��ǹ�ƽ����Ĭ���Ƿǹ�ƽ��
		lock.isFair();
		// ��ѯ��ǰ�߳��Ƿ�ռ�д���
		lock.isHeldByCurrentThread();
		// ��ѯ�����Ƿ񱻣������̣߳�ռ��
		lock.isLocked();
	}
}
