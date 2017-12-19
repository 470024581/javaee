package test.designPattern.behavior.chain;

/**
 *	请求处理人 
 **/
public abstract class PriceHandler {
	
	/**
	 * 直接后继，用于传递请求
	 **/
	protected PriceHandler successor;
	
	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}

	public abstract void processDiscount(float discount);
}
