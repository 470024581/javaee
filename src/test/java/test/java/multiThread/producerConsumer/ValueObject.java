package test.java.multiThread.producerConsumer;

public class ValueObject {
	
	public static String value = "";

	public static void main(String[] args) throws Exception {
		String lock = new String("");
		Producer p = new Producer(lock);
		Consumer c = new Consumer(lock);
		ThreadP pt = new ThreadP(p);
		ThreadC ct = new ThreadC(c);
		pt.start();
		ct.start();
		ThreadP pt1 = new ThreadP(p);
		ThreadC ct1 = new ThreadC(c);
		pt1.start();
		ct1.start();
		
		Thread.sleep(5000);
		Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadArray);
		for(int i=0; i<threadArray.length; i++) {
			System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
		}
	}
	
}
