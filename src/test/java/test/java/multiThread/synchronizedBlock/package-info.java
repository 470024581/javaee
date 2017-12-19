/**
 * 同步块
 * synchronized(非this对象x)，将x对象本身作为“对象监视器”
 * 1. 当多个线程同时执行synchronized(x){}同步代码块时，呈现同步效果
 * 2. 当其他线程执行x对象方法里面的synchronized同步方法时，呈现同步效果
 * 3. 当其他线程执行x对象方法里面的synchronized(this)代码块时，也呈现同步效果
 * 
 * 锁对象的改变，锁对象是可以改变的，如果对象不变，对象的属性改变，运行结果还是同步
 * 
 */
/**
 * @author lliang
 *
 */
package test.java.multiThread.synchronizedBlock;