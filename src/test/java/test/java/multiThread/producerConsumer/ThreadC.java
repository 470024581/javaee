package test.java.multiThread.producerConsumer;

public class ThreadC extends Thread {
	
	private Consumer consumer;
	
	public ThreadC(Consumer consumer) {
		this.consumer = consumer;
	}
	
	@Override
	public void run() {
		while(true) {
			consumer.getValue();
		}
	}


}
