package test.designPattern.behavior.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 *	环境（context）类定义出从变量到布尔值的一个映射
 **/
public class Context {
	
	private Map<Variable, Boolean> map = new HashMap<Variable, Boolean>();

	public void assign(Variable var, boolean value){
		map.put(var, new Boolean(value));
	}
	
	public boolean lookup(Variable variable) throws IllegalArgumentException {
		Boolean value = map.get(variable);
		if(value == null){
			throw new IllegalArgumentException();
		}
		return value.booleanValue();
	}
	
}
