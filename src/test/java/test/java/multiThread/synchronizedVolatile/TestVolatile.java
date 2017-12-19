package test.java.multiThread.synchronizedVolatile;

/**
 * 
 * @author lliang
 *
 */
public class TestVolatile extends Thread {
	
	volatile public static int count;
	
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			count++;
			System.out.println("count="+count);
		}
	}
	
	// 最后的结果可能不是10000，如果使用synchronized保证原子性，可以使最后10000打印
	public static void main(String[] args) {
		TestVolatile[] arr = new TestVolatile[100];
		for(int i=0; i<100; i++) {
			arr[i] = new TestVolatile();
		}
		for(int i=0; i<100; i++) {
			arr[i].start();
		}
	}
	
}
