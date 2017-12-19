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
					System.out.println("������"+Thread.currentThread().getName()+"waiting�ˣ�");
					lock.wait();
				}
				System.out.println("������"+Thread.currentThread().getName()+"runnable�ˣ�");
				System.out.println(Thread.currentThread().getName()+" get ��ֵ�ǣ�" + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
