package com.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 比较工具类
 * @author ylxu
 * @datetime 2016年3月14日 上午11:26:55
 */
public class CompareUtil {
	private static final Logger logger = LoggerFactory.getLogger(CompareUtil.class);
	
	public static List<String> basicTypeList;
	
    static{
    	basicTypeList =new ArrayList<String>();
    	basicTypeList.add("java.lang.Integer");
    	basicTypeList.add("java.lang.Short");
    	basicTypeList.add("java.lang.Byte");
    	basicTypeList.add("java.lang.Long");
    	basicTypeList.add("java.lang.Float");
    	basicTypeList.add("java.lang.Double");
    	basicTypeList.add("java.math.BigDecimal");
    	basicTypeList.add("java.lang.Character");
    	basicTypeList.add("java.lang.Boolean");
    	basicTypeList.add("java.lang.String");
    	basicTypeList.add("java.util.Date");
    	basicTypeList.add("java.lang.Long");
    	
    }
	
    /**
     * 比较两个对象属性修改情况
     * @param source	   原始对象
     * @param updator	   更新对象
     * @param compareList  设置比较列的name
     * @return
     * @throws IntrospectionException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
	public static Map<String,String> compareFields(Object source, Object updator, List<String> compareList){
    	//存储修改的内容:key为字段,value为修改的内容
        Map<String, String > map =new HashMap<String,String>();

        //如果都 源数据 和 修改数据 都为null
        if(source ==null&& updator ==null){
        	return map;
        }
        
		Field[] fields =updator.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName =field.getName();
			
			if(!compareList.contains(fieldName)){
				continue;
			}
			//会反射出以下属性,忽略
			if(fieldName.equals("serialVersionUID")||fieldName.equals("value")||fieldName.equals("offset")||fieldName.equals("count")||fieldName.equals("hash")||fieldName.equals("serialPersistentFields")||fieldName.equals("CASE_INSENSITIVE_ORDER")){
				continue;
			}
			//新建属性描述器,传入参数属性名及所属类
			PropertyDescriptor pd=null;
			try {
				pd = new PropertyDescriptor(fieldName,updator.getClass());
			} catch (IntrospectionException e) {
				logger.error("新建属性描述器失败",e);
			}
			//得到get方法
			Method getMethod =pd.getReadMethod();
			Object o1 =null;
			Object o2 =null;
			try {
				o1 = getMethod.invoke(source);
				o2 =getMethod.invoke(updator);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				logger.error("调用get方法失败,fieldName:"+fieldName+"--fieldName:"+fieldName.getClass().getName(),e);
			}
			String ooClassName ="";
			if(o2 !=null){
				ooClassName =o2.getClass().getName();					
			}else if(o1 !=null){
				ooClassName =o1.getClass().getName();
			}
			
			if(!"".equals(ooClassName)){
				//如果包含数据类型
				if(basicTypeList.contains(ooClassName)){
					//判断o1是否为空
					if(o1!=null){
						if(!o1.equals(o2)){
							map.put(fieldName, "将  "+o1+" 改为  "+o2);
						}							
					}else if(o2!=null){
						map.put(fieldName, "将null "+" 改为  "+o2);
					}    						
				}
			}				
		}
    	
    	return map;
    }
}
