package test.java.multiThread.producerConsumer;

public class Consumer {
	
	private String lock;
	
	public Consumer(String lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		try {
			synchronized (lock) {
				if(ValueObject.value.equals("")) {
					System.out.println("消费者"+Thread.currentThread().getName()+"waiting了！");
					lock.wait();
				}
				System.out.println("消费者"+Thread.currentThread().getName()+"runnable了！");
				System.out.println(Thread.currentThread().getName()+" get 的值是：" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
