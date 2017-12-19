package test.designPattern.structural.proxy.static_;

public class ProxySubject implements Subject {
	//����ʵ��ɫ��Ϊ�����ɫ������
	private RealSubject realSubject;

	@Override
	public void request() {
		preRequest();
		if(realSubject == null) {
			realSubject = new RealSubject();
		}
		realSubject.request();
		postRequest();
	}
	
	private void preRequest(){ 
		//something you want to do before requesting 
	}
	private void postRequest(){ 
		//something you want to do after requesting 
	}


}
