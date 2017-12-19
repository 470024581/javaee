package test.java.multiThread.lock;

public class ThreadB extends Thread {
	
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public ThreadB(String name, ReentrantReadWriteLock lock){
		this.setName(name);
		this.lock = lock;
	}
	
	public void run(){
		lock.write();
	}

}
