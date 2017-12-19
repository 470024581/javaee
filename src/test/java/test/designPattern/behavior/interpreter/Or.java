package test.designPattern.behavior.interpreter;

public class Or extends Expression {
	
	private Expression left,right;
	
	public Or(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Or){
			return this.left.equals(((Or) obj).left) && this.right.equals(((Or) obj).right);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return "("+left.toString()+" OR "+right.toString()+")";
	}

	@Override
	public boolean interpreter(Context ctx) {
		return left.interpreter(ctx) || right.interpreter(ctx);
	}

}
