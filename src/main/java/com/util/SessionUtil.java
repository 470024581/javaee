/**
 * SessionUtil.java
 */
package com.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户会话工具类，用来获取当前请求的上下文信息。
 * 
 * @author martin
 * @version 0.0.1
 */
public class SessionUtil {
	private static final String CLIENT_IP = "clientIp";
	private static final String USER_ID = "userId";
	private static final String CUSTOMER_ID = "customerId";
	private static final String CLIENT_ID = "clientId";
	private static ThreadLocal<Map<String, Object>> session = new ThreadLocal<Map<String, Object>>(){
		public Map<String, Object> initialValue(){
			return new HashMap<String, Object>();
		}
	};
	
	public static String getClientId(){
		return (String)session.get().get(CLIENT_ID);
	}
	
	public static Long getCustomerId(){
		return (Long)session.get().get(CUSTOMER_ID);
	}
	
	public static Long getUserId(){
		return (Long)session.get().get(USER_ID);
	}
	
	public static String getClientIp(){
		return (String)session.get().get(CLIENT_IP);
	}
	
	public static void init(String clientId, Long customerId, Long userId, String clientIp){
		session.get().clear();
		session.get().put(CLIENT_ID, clientId);
		session.get().put(CUSTOMER_ID, customerId);
		session.get().put(USER_ID, userId);
		session.get().put(CLIENT_IP, clientIp);
	}
}
