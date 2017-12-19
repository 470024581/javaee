/**
 * 多线程中join的使用：如果主线程希望子线程执行完成之后再结束、主线程要取得子线程处理后的数据，可以使用join方法
 * join作用：使所属线程正常执行run方法中的任务，而使当前线程无限期的阻塞，等待所属线程销毁后再继续执行当前线程
 * join方法释放对象锁，sleep方法不释放对象锁
 * 
 * 
 * ThreadLocal 存放各个线程私有的变量
 * 继承该类，实现initialValue方法，可以设置初始值
 * 
 * 
 * InheritableThreadLocal 类可以让子线程从父线程中取得值
 * 继承该类可以设置初始值，实现childValue可以修改子线程中获取的值，如果父线程修改了值，子线程继承的依旧是旧值
 */
/**
 * @author lliang
 *
 */
package test.java.multiThread.join;