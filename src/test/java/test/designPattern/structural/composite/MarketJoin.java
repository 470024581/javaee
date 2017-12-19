package test.designPattern.structural.composite;

//加盟店：下面不再有分店或加盟店，是最底层
public class MarketJoin extends Market {
	
	public MarketJoin(String name){
		this.name = name;
	}

	@Override
	public void add(Market m) {
		//最底层的叶子节点不具备操作功能
	}

	@Override
	public void remove(Market m) {
		//最底层的叶子节点不具备操作功能
	}

	@Override
	public void PayByCard() {
		System.out.println(name + "消费，积分已累加入该会员卡！");
	}

}
