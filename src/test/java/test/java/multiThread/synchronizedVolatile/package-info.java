/**
 * volatile和synchronized的比较：
 * 1. volatile是线程同步的轻量级实现，性能更佳，且只修饰变量；synchronized可以修饰方法，代码块
 * 2. 多线程访问volatile不会发成阻塞，而synchronized会出现阻塞
 * 3. volatile能保证数据的可见性，但不能保证原子性；而synchronized可以保证原子性，也能间接保证可见性，因为它会将私有内存和共有内存中的数据做同步
 */
/**
 * @author lliang
 *
 */
package test.java.multiThread.synchronizedVolatile;