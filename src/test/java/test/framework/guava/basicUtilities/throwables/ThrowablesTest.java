package test.framework.guava.basicUtilities.throwables;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.google.common.base.Throwables;

/**
 * guava 1.5-Throwables�����쳣�ʹ���Ĵ�������
 * 
 * @author lliang
 *
 */
public class ThrowablesTest {
	
	// 1.�쳣����
	
	// 2.�쳣ԭ����
//	Throwable   getRootCause(Throwable)			��ȡ����ԭ��
//	List<Throwable>   getCausalChain(Throwable) ��ȡ�����
//	String   getStackTraceAsString(Throwable)	��ȡջ��Ϣ
	
	public static void main(String[] args) throws IOException, SQLException {
		try {
//		    someMethodThatCouldThrowAnything();
		} catch (Exception e) {
			// ��������Ҫ������쳣�������Ǵ���Ĵ���
//		    handle(e);
		} catch (Throwable t) {
			// ʹ���������׳�IOException��SQLException�������쳣
		    Throwables.propagateIfInstanceOf(t, IOException.class);
		    Throwables.propagateIfInstanceOf(t, SQLException.class);
		    
		    Throwables.propagateIfPossible(t);// t������ΪError��RuntimeException���׳�
		    Throwables.propagateIfPossible(t, IOException.class); // t������Ϊ����2������3�����ͻ�Error��RuntimeException���׳�
		    Throwables.propagateIfPossible(t, IOException.class, SQLException.class);
		    
		    Throwable th = Throwables.getRootCause(t);
		    List<Throwable> thList = Throwables.getCausalChain(t);
		    String str = Throwables.getStackTraceAsString(t);
		    
		    throw Throwables.propagate(t);// ���t��Error��RuntimeExceptionֱ���׳������߰�t��װ��RuntimeException�׳�
		}

	}

}
