package test.designPattern.behavior.chain;

public class PriceHandlerFactory {

	/**
	 *	����priceHandler�Ĺ�������
	 **/
	public static PriceHandler createPriceHandler() {
		PriceHandler saler = new Saler();
		PriceHandler manager = new Manager();
		PriceHandler ceo = new Ceo();
		saler.setSuccessor(manager);
		manager.setSuccessor(ceo);
		return saler;
	}

}
