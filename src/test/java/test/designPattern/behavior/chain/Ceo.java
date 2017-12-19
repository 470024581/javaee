package test.designPattern.behavior.chain;

public class Ceo extends PriceHandler {

	@Override
	public void processDiscount(float discount) {
		if(discount <= 0.3){
			System.out.format("%s��׼���ۿۣ�%.2f%n", this.getClass().getName(), discount);
		} else {
			System.out.format("%s�ܾ����ۿۣ�%.2f%n", this.getClass().getName(), discount);
		}
	}

}
