package test.designPattern.behavior.mediator;

public class Client {
	public static void main(String[] args) {
		AbstractColleague collA = new ColleagueA();  
        AbstractColleague collB = new ColleagueB();  
        
        System.out.println("==========����AӰ��B==========");
        collA.setNumber(1288, collB);
        System.out.println("collA��numberֵ��"+collA.getNumber());
        System.out.println("collB��numberֵ��"+collB.getNumber());

        System.out.println("==========����BӰ��A==========");
        collB.setNumber(87635, collA);
        System.out.println("collB��numberֵ��"+collB.getNumber());
        System.out.println("collA��numberֵ��"+collA.getNumber());
        //�����н�
        AbstractMediator am = new Mediator(collA,collB);
        System.out.println("==========����AӰ��B==========");
        collA.setNumber(1288, am);
        System.out.println("collA��numberֵ��"+collA.getNumber());
        System.out.println("collB��numberֵΪA��10����"+collB.getNumber());
        
        System.out.println("==========����AӰ��B==========");
        collB.setNumber(87635, am);
        System.out.println("collB��numberֵ��"+collB.getNumber());
        System.out.println("collA��numberֵΪB��0.01����"+collA.getNumber());
        
	}
}
