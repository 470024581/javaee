package test.java.multiThread.producerConsumer;

public class Producer {
	
	private String lock;
	
	public Producer(String lock) {
		this.lock = lock;
	}
	
	public void setValue() {
		try {
			synchronized (lock) {
				if(!ValueObject.value.equals("")) {
					System.out.println("生产者"+Thread.currentThread().getName()+"waiting了！");
					lock.wait();
				}
				System.out.println("生产者"+Thread.currentThread().getName()+"runnable了！");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println(Thread.currentThread().getName()+" set 的值是：" + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
