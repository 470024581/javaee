package test.designPattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

//分店
public class MarketBranch extends Market {
	//加盟店列表
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
		System.out.println(name + "消费，积分已累加入该会员卡！");
		//分店可以操作分店下的分店，以及加盟店
		for(Market m : list){
			m.PayByCard();
		}
	}

}
