package test.framework.drools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.drools.RuleBase;
import org.drools.RuleBaseFactory;
import org.drools.WorkingMemory;
import org.drools.compiler.DroolsParserException;
import org.drools.compiler.PackageBuilder;
import org.drools.event.DebugWorkingMemoryEventListener;
import org.drools.rule.Package;

public class RuleEngine {

	private RuleBase rules;

	private boolean debug = false;

	public RuleEngine(String rulesFile) throws DroolsParserException {
		super();
		try {
			// 读取规则文件，*.drl
			Reader source = new InputStreamReader(
					RuleEngine.class.getResourceAsStream("/" + rulesFile));

			// PackageBuilder用来构建Package
			PackageBuilder builder = new PackageBuilder();

			// 解析和编译规则文件
			builder.addPackageFromDrl(source);

			// 获取包中的规则集合
			Package pkg = builder.getPackage();

			// RuleBase是运行时组件，包含一个或多个Package
			rules = RuleBaseFactory.newRuleBase();

			rules.addPackage(pkg);
		} catch (Exception e) {
			throw new DroolsParserException(
					"Could not load/compile rules file: " + rulesFile, e);
		}
	}
	
	public void execute() throws FileNotFoundException{
		// 获取测试脚本文件
		String ruleFilePath = "F:/mywork/workspace4/test/src/main/java/com/drools/demo/point/subpoint3.drl";
		
		// 装载测试脚本文件
		Reader reader = (Reader) new FileReader(new File(ruleFilePath));

		PackageBuilder backageBuilder = new PackageBuilder();
		try {
			backageBuilder.addPackageFromDrl(reader);
		} catch (DroolsParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public void executeRules(WorkingEnvironmentCallback callback) {
		WorkingMemory workingMemory = rules.newStatefulSession();
		if (debug) {
			workingMemory.addEventListener(new DebugWorkingMemoryEventListener());
		}
		callback.initEnvironment(workingMemory);// 用来向Working Memory中设置Facts对象
		workingMemory.fireAllRules();// 触发规则引擎
	}

}
