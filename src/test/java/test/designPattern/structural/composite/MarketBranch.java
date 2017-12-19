package test.designPattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

//�ֵ�
public class MarketBranch extends Market {
	//���˵��б�
	List<Market> list = new ArrayList<Market>(); 
	
	public MarketBranch(String name){
		this.name = name;
	}

	@Override
	public void add(Market m) {
		list.add(m);
	}

	@Override
	public void remove(Market m) {
		list.remove(m);
	}

	@Override
	public void PayByCard() {
		System.out.println(name + "���ѣ��������ۼ���û�Ա����");
		//�ֵ���Բ����ֵ��µķֵ꣬�Լ����˵�
		for(Market m : list){
			m.PayByCard();
		}
	}

}
