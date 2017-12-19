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
 * 1 @Test 把方法标识成单元测试方法，测试方法必须是public void可以抛出异常。
 * 		@Test(expected = xx.class, timeout = 毫秒数) 预期可以忽略的异常，以及测试方法的运行超时时间
 * 2 @Ignore 暂时不运行某些测试方法，不建议经常使用
 * 3 @BeforeClass 在运行测试方法之前，运行一次该方法，用于创建数据库连接，读取文件，初始化数据等
 * 4 @AfterClass 在所有用例运行之后，运行一次，用于测试后续工作如清理数据，释放连接等
 * 		（BeforeClass和AfterClass）方法名可以是任意，但需要是public static void，且只会运行一次
 * 5 @Before 在每个用例执行之前，执行一次，用于一些独立于用例之间的准备工作，如用例1要删除用户a，用户2要修改用户a，@Before可以用来插入用户a
 * 6 @After	 与before对应，且都必须是public void
 * 7 @Runwith(xx.class) 修饰类，确定该类适用哪种运行器运行，xx的值如下：
 * 		1.Parameterized 参数化运行器，配合@Parameters适用junit的参数化功能
 * 		2.Suite 测试集运行期配合使用测试集功能，配合@Suite({ATest.class,BTest.class})
 * 		3.JUnit4 junit4的默认运行器
 * 		4.JUnit38ClassRunner 用于兼容junit3.8的运行器
 * 		5.SpringJUnit4ClassRunner 集成了spring的一些功能
 * 8 @parameters 用于使用参数化功能
 **/
public class JunitAndAssert {
	
	private static ApplicationContext context;
	
	@BeforeClass
	public static void init(){
		context = new ClassPathXmlApplicationContext("spring-servlet.xml");
	}

	/**
	 * Assert 常用的方法
	 **/
	@Test
	public void testAssert(){
		// 断言a和b是否相同，若非原始类型，比较实现的equals方法，有各种重载的实现方法
		Assert.assertEquals("a", "b");
		// 断言结果是真或假
		boolean a = true;
		Assert.assertTrue(a);
		Assert.assertFalse(a);
		// 断言为空或非空
		Assert.assertNull(a);
		Assert.assertNotNull(a);
		// 断言两个变量是否引用同一对象
		Assert.assertSame("a", "b");
		Assert.assertNotSame("a", "b");
	}
	
	@Test
	public void testMock() {
		// 通过动态代理创建对象
		JunitAndAssert mock = EasyMock.createMock(JunitAndAssert.class);
		System.out.println(mock.toString());
		// 录制预期行为，先录制才能适用具体的参数
//		EasyMock.expect(mock.querySupply("1234")).andReturn("5555");
		// 重放mock对象，测试时以录制的对象预期行为代替真实对象的行为
//		EasyMock.replay(mock);
		
		// 运行异常，因为没有录制该参数的行为
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
          
        // logback提供的可以使用变量的打印方式，结果为"Hello,Aub!"  
        log.info("Hello,{}!", name);  
          
        // 可以有多个参数,结果为“Hello,Aub! 3Q!”  
        log.info("Hello,{}!   {}!", name, message);  
          
        // 可以传入一个数组，结果为"Fruit:  apple,banana"  
        log.error("Fruit:  {},{}", fruits);   
	}

}
