package test.designPattern.behavior.strategy;

public class Client {

	public static void main(String[] args) {
		Animal bird = new Animal(new Fly());
		bird.run();
		Animal dog = new Animal(new Walk());
		dog.run();
	}

}
