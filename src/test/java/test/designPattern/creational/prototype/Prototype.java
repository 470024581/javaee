package test.designPattern.creational.prototype;

import java.util.ArrayList;

/**
 *	ԭ��ģʽ����ԭ��ʵ��ָ��������������࣬����ͨ��������Щԭ�ʹ����µĶ���
 * 	�ŵ㣺����������ʱ��̬�ı䣨���Ͻӿڵģ������ʵ�����ͣ���ʵ����
 * 	ȱ�㣺����Ҫ�߱�һ����¡���������ܻ�Ҫ���Ǳ���¡�����������������ã�
 * 	��δ���ԭ���ࣺʵ��Cloneable�ӿڣ���дclone����
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
