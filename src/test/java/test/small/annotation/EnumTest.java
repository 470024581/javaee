package test.small.annotation;

public enum EnumTest {
	
	YELLOW("��ɫ"),RED("��ɫ"),Bule("��ɫ");
	
	private EnumTest(String lamp){
		this.lamp = lamp;
	}
	
	private String lamp;

	public String getLamp() {
		return lamp;
	}

}
