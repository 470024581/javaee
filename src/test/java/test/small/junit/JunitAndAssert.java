package test.small.junit;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 1 @Test �ѷ�����ʶ�ɵ�Ԫ���Է��������Է���������public void�����׳��쳣��
 * 		@Test(expected = xx.class, timeout = ������) Ԥ�ڿ��Ժ��Ե��쳣���Լ����Է��������г�ʱʱ��
 * 2 @Ignore ��ʱ������ĳЩ���Է����������龭��ʹ��
 * 3 @BeforeClass �����в��Է���֮ǰ������һ�θ÷��������ڴ������ݿ����ӣ���ȡ�ļ�����ʼ�����ݵ�
 * 4 @AfterClass ��������������֮������һ�Σ����ڲ��Ժ����������������ݣ��ͷ����ӵ�
 * 		��BeforeClass��AfterClass�����������������⣬����Ҫ��public static void����ֻ������һ��
 * 5 @Before ��ÿ������ִ��֮ǰ��ִ��һ�Σ�����һЩ����������֮���׼��������������1Ҫɾ���û�a���û�2Ҫ�޸��û�a��@Before�������������û�a
 * 6 @After	 ��before��Ӧ���Ҷ�������public void
 * 7 @Runwith(xx.class) �����࣬ȷ�����������������������У�xx��ֵ���£�
 * 		1.Parameterized �����������������@Parameters����junit�Ĳ���������
 * 		2.Suite ���Լ����������ʹ�ò��Լ����ܣ����@Suite({ATest.class,BTest.class})
 * 		3.JUnit4 junit4��Ĭ��������
 * 		4.JUnit38ClassRunner ���ڼ���junit3.8��������
 * 		5.SpringJUnit4ClassRunner ������spring��һЩ����
 * 8 @parameters ����ʹ�ò���������
 **/
public class JunitAndAssert {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
	}

	/**
	 * Assert ���õķ���
	 **/
	@Test
	public void testAssert(){
		// ����a��b�Ƿ���ͬ������ԭʼ���ͣ��Ƚ�ʵ�ֵ�equals�������и������ص�ʵ�ַ���
		Assert.assertEquals("a", "b");
		// ���Խ��������
		boolean a = true;
		Assert.assertTrue(a);
		Assert.assertFalse(a);
		// ����Ϊ�ջ�ǿ�
		Assert.assertNull(a);
		Assert.assertNotNull(a);
		// �������������Ƿ�����ͬһ����
		Assert.assertSame("a", "b");
		Assert.assertNotSame("a", "b");
	}
	
	@Test
	public void testMock() {
		// ͨ����̬����������
		JunitAndAssert mock = EasyMock.createMock(JunitAndAssert.class);
		System.out.println(mock.toString());
		// ¼��Ԥ����Ϊ����¼�Ʋ������þ���Ĳ���
//		EasyMock.expect(mock.querySupply("1234")).andReturn("5555");
		// �ط�mock���󣬲���ʱ��¼�ƵĶ���Ԥ����Ϊ������ʵ�������Ϊ
//		EasyMock.replay(mock);
		
		// �����쳣����Ϊû��¼�Ƹò�������Ϊ
//		String return1 = mock.querySupply("123");
//		System.out.println(return1);
//		String return2 = mock.querySupply("1234");
//		System.out.println(return2);
		
		String str1 = "5555";
//		Assert.assertEquals(str1, return2);
		EasyMock.verify(mock);
	}
	
	/* logback */
	private static Logger log = LoggerFactory.getLogger(JunitAndAssert.class); 
	
	public static void main(String[] args) {
		log.trace("======trace");  
        log.debug("======debug");  
        log.info("======info");  
        log.warn("======warn");  
        log.error("======error");  
           
        String name = "Aub";  
        String message = "3Q";  
        String[] fruits = { "apple", "banana" };  
          
        // logback�ṩ�Ŀ���ʹ�ñ����Ĵ�ӡ��ʽ�����Ϊ"Hello,Aub!"  
        log.info("Hello,{}!", name);  
          
        // �����ж������,���Ϊ��Hello,Aub! 3Q!��  
        log.info("Hello,{}!   {}!", name, message);  
          
        // ���Դ���һ�����飬���Ϊ"Fruit:  apple,banana"  
        log.error("Fruit:  {},{}", fruits);   
	}

}
