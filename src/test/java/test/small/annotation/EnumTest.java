package test.small.annotation;

public enum EnumTest {
	
	YELLOW("»ÆÉ«"),RED("ºìÉ«"),Bule("À¶É«");
	
	private EnumTest(String lamp){
		this.lamp = lamp;
	}
	
	private String lamp;

	public String getLamp() {
		return lamp;
	}

}
