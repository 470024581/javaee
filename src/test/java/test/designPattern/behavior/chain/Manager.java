package test.designPattern.behavior.chain;

public class Manager extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount <= 0.2){
			System.out.format("%s��׼���ۿۣ�%.2f%n", this.getClass().getName(), discount);
		} else {
			successor.processDiscount(discount);
		}
	}

}
