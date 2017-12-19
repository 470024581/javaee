package test.designPattern.behavior.template;

public class Client {

	public static void main(String[] args) {
		Template coder = new Coder();
		coder.workTemplate();
		Template worker = new Worker();
		worker.workTemplate();
	}

}
