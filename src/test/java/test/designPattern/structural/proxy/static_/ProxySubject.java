package test.designPattern.structural.proxy.static_;

public class ProxySubject implements Subject {
	//以真实角色作为代理角色的属性
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
