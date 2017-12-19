package test.designPattern.behavior.chain;

import java.util.Random;

/**
 *	øÕªß«Î«Û’€ø€ 
 **/
public class Customer {
	private PriceHandler priceHandler;

	public void setPriceHandler(PriceHandler priceHandler) {
		this.priceHandler = priceHandler;
	}
	
	public void requestDiscount(float discount){
		priceHandler.processDiscount(discount);
	}
	
	public static void main(String[] args) {
		Customer c = new Customer();
		c.setPriceHandler(PriceHandlerFactory.createPriceHandler());
		for(int i=1; i<100; i++){
			System.out.print(i+":");
			c.requestDiscount(new Random().nextFloat());
		}
	}
	
}
