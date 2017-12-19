package test.designPattern.creational.prototype;

import java.util.ArrayList;

/**
 *	原型模式：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
 * 	优点：允许在运行时动态改变（符合接口的）具体的实现类型（或实例）
 * 	缺点：必须要具备一个克隆方法（可能还要考虑被克隆对象对其他对象的引用）
 * 	如何创建原型类：实现Cloneable接口，重写clone方法
 **/
public class Prototype implements Cloneable {
	
	private String name;
	
	private ArrayList list = new ArrayList();
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList getList() {
		return list;
	}

	public void setList(ArrayList list) {
		this.list = list;
	}
	
	@Override
	public Prototype clone() { 
    	Prototype prototype = null; 
        try { 
            prototype = (Prototype) super.clone(); 
            prototype.list = (ArrayList) this.list.clone(); 
        } catch (CloneNotSupportedException e) { 
            e.printStackTrace(); 
        } 
        return prototype; 
    } 
	
	public static void main(String[] args) {
		Prototype p = new Prototype();
		p.setName("china");
		ArrayList list = new ArrayList();
		list.add("123");
		p.setList(list);
		
		Prototype p1 = p.clone();
		System.out.println(p1.list.toString()+","+p.getName());
	}

}
