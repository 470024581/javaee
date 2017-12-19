package test.designPattern.behavior.interpreter;

/**
 *	�����߼����롱������And�࣬��ʾ�������������ʽͨ���߼����롱��������һ���µĲ������ʽ�Ĳ���
 **/
public class And extends Expression {
	
	private Expression left,right;
	
	public And(Expression left, Expression right){
		this.left = left;
		this.right = right;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof And){
			return this.left.equals(((And) obj).left) && this.right.equals(((And) obj).right);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public String toString() {
		return "("+left.toString()+" AND "+right.toString()+")";
	}

	@Override
	public boolean interpreter(Context ctx) {
		return left.interpreter(ctx) && right.interpreter(ctx);
	}

}
