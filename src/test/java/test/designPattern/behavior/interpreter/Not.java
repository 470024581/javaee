package test.designPattern.behavior.interpreter;

public class Not extends Expression {
	
	private Expression exp;
	
	public Not(Expression exp){
		this.exp = exp;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Not){
			return exp.equals(((Not) obj).exp);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return "(NOT "+exp.toString()+")";
	}

	@Override
	public boolean interpreter(Context ctx) {
		return !exp.interpreter(ctx);
	}

}
