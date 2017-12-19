package test.framework.drools;

import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;

public class Test {

	public static void main(String[] args) {
		RuleEngine engine = null;
		try {
			engine = new RuleEngine("test.drl");
		} catch (DroolsParserException e) {
			// process Exception
		}
		engine.executeRules(new WorkingEnvironmentCallback() {
			public void initEnvironment(WorkingMemory workingMemory) {
				try{
					workingMemory.insert("jack"); // ��Working Memory������Facts����
				} catch (Exception e){
					System.out.println(e.getStackTrace());
				}
			}
		});
	}
}
