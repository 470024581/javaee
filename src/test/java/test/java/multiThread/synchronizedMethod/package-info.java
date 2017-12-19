/**
 * 同步方法：
 * synchronized方法或代码块：多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时，调用的效果是按顺序的，就是同步的，阻塞的
 * 
 * 多个对象多个锁：一个类上的多个同步方法被多个线程的同一个对象访问时，会有同步锁，因为单个对象只持有一把锁，
 * 			 一个类上的多个同步方法被多个线程的多个对象访问时，不会有同步锁，因为多个对象拥有多把锁
 * 同步块类似于同步方法
 */
/**
 * @author lliang
 *
 */
package test.java.multiThread.synchronizedMethod;