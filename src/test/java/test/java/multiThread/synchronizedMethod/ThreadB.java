package test.java.multiThread.synchronizedMethod;

public class ThreadB extends Thread {
	
	private HasSelfPrivateNum num;
	
	public ThreadB(HasSelfPrivateNum num) {
		this.num = num;
	}

	@Override
	public void run() {
		num.addI("b");
	}

}
