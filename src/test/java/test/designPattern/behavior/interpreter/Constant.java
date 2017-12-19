package test.designPattern.behavior.interpreter;

/**
 *	һ��Constant�������һ����������
 **/
public class Constant extends Expression {
	
	private boolean value;
	
	public Constant(boolean value){
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Constant){
			return this.value == ((Constant) obj).value;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return new Boolean(value).toString();
	}

	@Override
	public boolean interpreter(Context ctx) {
		return value;
	}

}
