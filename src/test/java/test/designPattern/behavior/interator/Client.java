package test.designPattern.behavior.interator;

public class Client {
	public static void main(String[] args) {
		Aggregat agg = new ConcreteAggregat();
		Iterator iterator = agg.createIterator();
		System.out.println(iterator.first());
		while(!iterator.isDone()){
			System.out.println(iterator.next());
		}
	}
}
