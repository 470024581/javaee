package test.java.multiThread.lock;

/**
 * ��д������������������������д�����ͻ��⣨��������
 * 
 * @author lliang
 *
 */
public class ReentrantReadWriteLock {
	
	java.util.concurrent.locks.ReentrantReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
	
	public static void main(String[] args) throws InterruptedException {
		// ��д���⣬��������
		ReentrantReadWriteLock l = new ReentrantReadWriteLock();
		ThreadA a = new ThreadA("A", l);
		ThreadB b = new ThreadB("B", l);
		ThreadC c = new ThreadC("C", l);
		a.start();
		b.start();
		c.start();
		
//		new Thread("A"){
//			public void run() {
//				read();
//			};
//		}.start();
////		Thread.sleep(1000);
//		new Thread("B"){
//			public void run() {
//				write();
//			};
//		}.start();
////		Thread.sleep(1000);
//		new Thread("C"){
//			public void run() {
//				read();
//			};
//		}.start();
	}
	
	public void read(){
		try {
			try{
				lock.readLock().lock();
				System.out.println("��ö���:" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
				Thread.sleep(3000);
			} finally {
				lock.readLock().unlock();
				System.out.println("�ͷŶ���:" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void write(){
		try {
			try{
				lock.writeLock().lock();
				System.out.println("���д��:" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
				Thread.sleep(3000);
			} finally {
				lock.writeLock().unlock();
				System.out.println("�ͷ�д��:" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
