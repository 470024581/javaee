package test.designPattern.behavior.chain;

public class Saler extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount <= 0.1){
			System.out.format("%sÅú×¼ÁËÕÛ¿Û£º%.2f%n", this.getClass().getName(), discount);
			System.out.println();
		} else {
			successor.processDiscount(discount);
		}
	}

}
