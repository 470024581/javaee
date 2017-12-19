package test.designPattern.structural.adapter;

/**
 * 	������ģʽ����һ����Ľӿ�ת���ɿͻ�ϣ��������һ���ӿڡ�Adapterģʽʹ��ԭ�����ڽӿڲ����ݶ�����һ��������Щ�����һ������
 * 	������������ͨ�������ί�ɣ�ʵ��Ŀ��ӿڵ�API���Ƽ�ʹ�����ַ�ʽ�����
 * 	�����ԣ�1.����ʹ��һ���Ѿ����ڵ��࣬�����Ľӿڲ������������
 *		2.���봴��һ�����Ը��õ��࣬�����������������ص���򲻿�Ԥ������Эͬ����
 *		3.���������ڶ���Adapter������ʹ��һЩ�Ѿ����ڵ����࣬�������ܶ�ÿ�����������໯��ƥ�����ǵĽӿڡ����������������������ĸ���ӿڡ�
 *	�ŵ㣺���õĸ��ã����õ���չ
 *	ȱ�㣺�����������������ϵͳ���ң�����������ѿأ�������Ǻ��б�Ҫ�����Բ�ʹ�ã������ع�ϵͳ
 **/
public class ObjectAdapter {
	private Adapter adapter;
	public ObjectAdapter(Adapter adaptee){ 
		this.adapter = adaptee; 
	}
	public void sampleOperation1(){
		this.adapter.sampleOperation1();
	}
	public void sampleOperation2(){ 
		//��ش��� 
	}
}
