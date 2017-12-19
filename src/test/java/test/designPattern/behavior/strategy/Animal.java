package test.designPattern.behavior.strategy;

public class Animal {
	
	public IStrategy strategy;
	
	public Animal(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void run(){
		strategy.operate();
	}

}
