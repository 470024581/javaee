package test.designPattern.behavior.chain;

/**
 *	�������� 
 **/
public abstract class PriceHandler {
	
	/**
	 * ֱ�Ӻ�̣����ڴ�������
	 **/
	protected PriceHandler successor;
	
	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}

	public abstract void processDiscount(float discount);
}
