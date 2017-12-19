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
					System.out.println("������"+Thread.currentThread().getName()+"waiting�ˣ�");
					lock.wait();
				}
				System.out.println("������"+Thread.currentThread().getName()+"runnable�ˣ�");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println(Thread.currentThread().getName()+" set ��ֵ�ǣ�" + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
