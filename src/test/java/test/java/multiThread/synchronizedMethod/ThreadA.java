package test.java.multiThread.synchronizedMethod;

public class ThreadA extends Thread {

	private HasSelfPrivateNum num;
	
	public ThreadA(HasSelfPrivateNum num) {
		this.num = num;
	}

	@Override
	public void run() {
		num.addI("a");
	}

}
