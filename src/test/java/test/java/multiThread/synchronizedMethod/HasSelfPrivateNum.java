package test.java.multiThread.synchronizedMethod;

import java.lang.reflect.Array;

public class HasSelfPrivateNum {
	
	private int num = 0;
	
	synchronized public void addI(String username) {
		try {
			if("a".equals(username)) {
				num = 100;
				System.out.println("a set over!");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over!");
			}
			System.out.println(username + " num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		HasSelfPrivateNum aNum = new HasSelfPrivateNum();
		HasSelfPrivateNum bNum = new HasSelfPrivateNum();
		ThreadA a = new ThreadA(aNum);
		ThreadB b = new ThreadB(bNum);
		a.start();
		b.start();
	}

}
