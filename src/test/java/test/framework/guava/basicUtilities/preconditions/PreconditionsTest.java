package test.framework.guava.basicUtilities.preconditions;

import com.google.common.base.Preconditions;

/**
 * guava 1.2-ǰ������
 * �÷������õ�ǰ�������жϸ��򵥡�
 * 
 * @author lliang
 *
 */
public class PreconditionsTest {
	
	public static void main(String[] args) {
		
		Preconditions.checkArgument(true); // ���boolean�Ƿ�Ϊtrue��������鴫�ݸ������Ĳ��������ʧ��ʱ�׳����쳣IllegalArgumentException
		Preconditions.checkArgument(true, new Object());
		Preconditions.checkArgument(true, "errorTemplate", new Object());
		
		Preconditions.checkState(true);
		
		System.out.println(Preconditions.checkNotNull(new Object()));
		
		System.out.println(Preconditions.checkElementIndex(3, 4));
		
	}
//	ÿ�����������������֣�
//	û�ж���������׳����쳣��û�д�����Ϣ��
//	��һ��Object������Ϊ����������׳����쳣ʹ��Object.toString() ��Ϊ������Ϣ��
//	��һ��String������Ϊ���������������һ�����������ĸ���Object����������ִ����쳣��Ϣ�ķ�ʽ�е�����printf��������GWT�ļ����Ժ�Ч�ʣ�ֻ֧��%sָʾ�������磺
	
//	�������������������������							����																���ʧ��ʱ�׳����쳣
//	checkArgument(boolean)						���boolean�Ƿ�Ϊtrue��������鴫�ݸ������Ĳ�����								IllegalArgumentException
//	checkNotNull(T)								���value�Ƿ�Ϊnull���÷���ֱ�ӷ���value����˿�����Ƕʹ��checkNotNull��			NullPointerException
//	checkState(boolean)							�����������ĳЩ״̬��													IllegalStateException
//	checkElementIndex(int index, int size)		���index��Ϊ����ֵ��ĳ���б��ַ����������Ƿ���Ч��index>=0 && index<size *		IndexOutOfBoundsException
//	checkPositionIndex(int index, int size)		���index��Ϊλ��ֵ��ĳ���б��ַ����������Ƿ���Ч��index>=0 && index<=size *	IndexOutOfBoundsException
//	checkPositionIndexes(int start, int end, int size)	���[start, end]��ʾ��λ�÷�Χ��ĳ���б��ַ����������Ƿ���Ч*			IndexOutOfBoundsException

}
