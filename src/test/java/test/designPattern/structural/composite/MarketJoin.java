package test.designPattern.structural.composite;

//���˵꣺���治���зֵ����˵꣬����ײ�
public class MarketJoin extends Market {
	
	public MarketJoin(String name){
		this.name = name;
	}

	@Override
	public void add(Market m) {
		//��ײ��Ҷ�ӽڵ㲻�߱���������
	}

	@Override
	public void remove(Market m) {
		//��ײ��Ҷ�ӽڵ㲻�߱���������
	}

	@Override
	public void PayByCard() {
		System.out.println(name + "���ѣ��������ۼ���û�Ա����");
	}

}
