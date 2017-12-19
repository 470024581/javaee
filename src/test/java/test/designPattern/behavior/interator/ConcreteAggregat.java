package test.designPattern.behavior.interator;

import java.util.Vector;

public class ConcreteAggregat implements Aggregat {
	
	private Vector vector = null;
	
	public Vector getVector(){
		return vector;
	}
	
	public void setVector(Vector vector) {
		this.vector = vector;
	}
	
	public ConcreteAggregat(){
		vector = new Vector();
		vector.add("vector 1");
		vector.add("vector 2");
		vector.add("vector 3");
		vector.add("vector 3");
	}

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(vector);
	}

}
