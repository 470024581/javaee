package test.designPattern.structural.adapter;

/**
 *	类适配器：通过类的继承，实现目标接口的API 
 **/
public class ClassAdapter extends Adapter implements Target {

	//由于Adaptee中没有该方法，适配器中补充上该方法
	@Override
	public void sampleOperation2() {
		//相关代码
	}

}
