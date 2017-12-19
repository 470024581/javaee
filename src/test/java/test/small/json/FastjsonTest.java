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
	
//	API入口类是com.alibaba.fastjson.JSON，常用的序列化操作都可以在JSON类上的静态方法直接完成。
//	public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
//	public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject    
//	public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean 
//	public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray 
//	public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合 
//	public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
//	public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
//	public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
	
	private static SerializeConfig mapping = new SerializeConfig();
	
	static{
		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss")); 
	}
	
	public static void main(String[] args) throws IOException {
		UserBean user = new UserBean();
		user.setId(1);
		user.setName("小明");
		user.setDate(new Date());
		user.setSubUserBean(new SubUserBean(11,"大儿子"));
		List<String> attrList = new ArrayList<String>();
		attrList.add("123");
		attrList.add("456");
		user.setAttr(attrList);
		List<SubUserBean> subUserList = new ArrayList<SubUserBean>();
		subUserList.add(new SubUserBean(22, "二儿子"));
		subUserList.add(new SubUserBean(33, "三儿子"));
		user.setSubUserList(subUserList);
		// 使用mapping之后日期会按格式输出，不使用输出的是int类型（毫秒数？）
		String jsonStr = JSON.toJSONString(user, mapping);
		System.out.println(jsonStr);
		System.out.println(JSON.toJSONStringZ(user, mapping));
		// 把json字符转成JavaBean对象
		UserBean u = (UserBean) JSON.parseObject(jsonStr, UserBean.class);
		String name = u.getName();
		System.out.println(name);
		// 把json字符转成json对象
		JSONObject obj2 = JSON.parseObject(jsonStr);
		int id2 = obj2.getInteger("id");
		System.out.println(id2);
		// 另一种转成json对象的方式
		/*JSONObject obj = (JSONObject) JSON.parse(jsonStr);
		int id = obj.getInteger("id");
		System.out.println(id);*/
		
		
	}

}
