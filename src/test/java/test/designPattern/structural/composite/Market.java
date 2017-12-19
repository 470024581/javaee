package test.designPattern.structural.composite;

/**
 * 组合模式：将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性
 * 适用性：1.你想表示对象的部分-整体层次结构
 * 		2.你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象
 * 
 * 
 **/
public abstract class Market {
	String name;  
    public abstract void add(Market m);  
    public abstract void remove(Market m);  
    public abstract void PayByCard();  
}
