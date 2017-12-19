package test.java.multiThread.lock;

public class ThreadC extends Thread {
	
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public ThreadC(String name, ReentrantReadWriteLock lock){
		this.setName(name);
		this.lock = lock;
	}
	
	public void run(){
		lock.read();
	}

}
