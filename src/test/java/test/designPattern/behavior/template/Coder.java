package test.designPattern.behavior.template;

public class Coder extends Template {

	@Override
	public void work() {
		System.out.println("�����С�����");
	}

	@Override
	public boolean isCoder(){
		return true;
	}

}
