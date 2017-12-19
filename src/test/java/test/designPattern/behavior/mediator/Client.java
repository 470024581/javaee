package test.designPattern.behavior.mediator;

public class Client {
	public static void main(String[] args) {
		AbstractColleague collA = new ColleagueA();  
        AbstractColleague collB = new ColleagueB();  
        
        System.out.println("==========设置A影响B==========");
        collA.setNumber(1288, collB);
        System.out.println("collA的number值："+collA.getNumber());
        System.out.println("collB的number值："+collB.getNumber());

        System.out.println("==========设置B影响A==========");
        collB.setNumber(87635, collA);
        System.out.println("collB的number值："+collB.getNumber());
        System.out.println("collA的number值："+collA.getNumber());
        //加入中介
        AbstractMediator am = new Mediator(collA,collB);
        System.out.println("==========设置A影响B==========");
        collA.setNumber(1288, am);
        System.out.println("collA的number值："+collA.getNumber());
        System.out.println("collB的number值为A的10倍："+collB.getNumber());
        
        System.out.println("==========设置A影响B==========");
        collB.setNumber(87635, am);
        System.out.println("collB的number值："+collB.getNumber());
        System.out.println("collA的number值为B的0.01倍："+collA.getNumber());
        
	}
}
