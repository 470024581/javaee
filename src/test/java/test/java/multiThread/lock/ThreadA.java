package test.java.multiThread.lock;

public class ThreadA extends Thread {
	
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public ThreadA(String name, ReentrantReadWriteLock lock){
		this.setName(name);
		this.lock = lock;
	}
	
	public void run(){
		lock.read();
	}

}

