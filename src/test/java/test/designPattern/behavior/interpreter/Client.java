package test.designPattern.behavior.interpreter;

/**
 *	½âÊÍÆ÷Ä£Ê½ 
 **/
public class Client {
	public static void main(String[] args) {
		Context ctx = new Context();
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Constant c = new Constant(true);
		ctx.assign(x, false);
		ctx.assign(y, true);
		
		Expression exp = new Or(new And(c,x) , new And(y, new Not(x)));
		
		System.out.println("x=" + x.interpreter(ctx));
		System.out.println("y=" + y.interpreter(ctx));
		System.out.println(exp.toString() + "=" + exp.interpreter(ctx));
	}
}
