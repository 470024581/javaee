package test.designPattern.behavior.visitor;

public class Client {

	public static void main(String[] args) {
		ObjectStructure os = new ObjectStructure();
		os.add(new NodeA());
		os.add(new NodeB());
		Visitor visitor = new VisitorA();
		os.action(visitor);
	}
	
}