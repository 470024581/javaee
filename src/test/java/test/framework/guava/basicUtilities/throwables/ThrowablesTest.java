package test.framework.guava.basicUtilities.throwables;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.common.base.Throwables;

/**
 * guava 1.5-Throwables：简化异常和错误的传播与检查
 * 
 * @author lliang
 *
 */
public class ThrowablesTest {
	
	// 1.异常传播
	
	// 2.异常原因链
//	Throwable   getRootCause(Throwable)			获取根本原因
//	List<Throwable>   getCausalChain(Throwable) 获取因果链
//	String   getStackTraceAsString(Throwable)	获取栈信息
	
	public static void main(String[] args) throws IOException, SQLException {
		try {
//		    someMethodThatCouldThrowAnything();
		} catch (Exception e) {
			// 捕获了需要处理的异常，下面是处理的代码
//		    handle(e);
		} catch (Throwable t) {
			// 使方法必须抛出IOException和SQLException这两个异常
		    Throwables.propagateIfInstanceOf(t, IOException.class);
		    Throwables.propagateIfInstanceOf(t, SQLException.class);
		    
		    Throwables.propagateIfPossible(t);// t的类型为Error或RuntimeException才抛出
		    Throwables.propagateIfPossible(t, IOException.class); // t的类型为参数2、参数3的类型或Error或RuntimeException才抛出
		    Throwables.propagateIfPossible(t, IOException.class, SQLException.class);
		    
		    Throwable th = Throwables.getRootCause(t);
		    List<Throwable> thList = Throwables.getCausalChain(t);
		    String str = Throwables.getStackTraceAsString(t);
		    
		    throw Throwables.propagate(t);// 如果t是Error或RuntimeException直接抛出，否者把t包装成RuntimeException抛出
		}

	}

}
