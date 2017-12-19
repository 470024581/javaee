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
	
	// ���Ľ�����ܲ���10000�����ʹ��synchronized��֤ԭ���ԣ�����ʹ���10000��ӡ
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
