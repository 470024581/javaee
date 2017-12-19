package test.small.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

public class FastjsonTest {
	
//	API�������com.alibaba.fastjson.JSON�����õ����л�������������JSON���ϵľ�̬����ֱ����ɡ�
//	public static final Object parse(String text); // ��JSON�ı�parseΪJSONObject����JSONArray 
//	public static final JSONObject parseObject(String text)�� // ��JSON�ı�parse��JSONObject    
//	public static final <T> T parseObject(String text, Class<T> clazz); // ��JSON�ı�parseΪJavaBean 
//	public static final JSONArray parseArray(String text); // ��JSON�ı�parse��JSONArray 
//	public static final <T> List<T> parseArray(String text, Class<T> clazz); //��JSON�ı�parse��JavaBean���� 
//	public static final String toJSONString(Object object); // ��JavaBean���л�ΪJSON�ı� 
//	public static final String toJSONString(Object object, boolean prettyFormat); // ��JavaBean���л�Ϊ����ʽ��JSON�ı� 
//	public static final Object toJSON(Object javaObject); ��JavaBeanת��ΪJSONObject����JSONArray��
	
	private static SerializeConfig mapping = new SerializeConfig();
	
	static{
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss")); 
	}
	
	public static void main(String[] args) throws IOException {
		UserBean user = new UserBean();
		user.setId(1);
		user.setName("С��");
		user.setDate(new Date());
		user.setSubUserBean(new SubUserBean(11,"�����"));
		List<String> attrList = new ArrayList<String>();
		attrList.add("123");
		attrList.add("456");
		user.setAttr(attrList);
		List<SubUserBean> subUserList = new ArrayList<SubUserBean>();
		subUserList.add(new SubUserBean(22, "������"));
		subUserList.add(new SubUserBean(33, "������"));
		user.setSubUserList(subUserList);
		// ʹ��mapping֮�����ڻᰴ��ʽ�������ʹ���������int���ͣ�����������
		String jsonStr = JSON.toJSONString(user, mapping);
		System.out.println(jsonStr);
		System.out.println(JSON.toJSONStringZ(user, mapping));
		// ��json�ַ�ת��JavaBean����
		UserBean u = (UserBean) JSON.parseObject(jsonStr, UserBean.class);
		String name = u.getName();
		System.out.println(name);
		// ��json�ַ�ת��json����
		JSONObject obj2 = JSON.parseObject(jsonStr);
		int id2 = obj2.getInteger("id");
		System.out.println(id2);
		// ��һ��ת��json����ķ�ʽ
		/*JSONObject obj = (JSONObject) JSON.parse(jsonStr);
		int id = obj.getInteger("id");
		System.out.println(id);*/
		
		
	}

}
