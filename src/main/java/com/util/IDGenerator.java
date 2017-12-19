package com.util;

import java.util.Random;
import java.util.UUID;

/**
 * id生成器
 * 
 * @author qwu
 * @created 2016年2月24日 下午2:35:35
 * @version 0.0.1
 */
public class IDGenerator {

	/**
	 * 
	 * 生成唯一ID<br>
	 * 
	 * 6位随机数+13位时间戳
	 * 
	 * @return
	 */
	public static synchronized String getId() {
		try {
			// 时间，毫秒级
			String time = String.valueOf(System.currentTimeMillis());
			// 6位随机数
			Random rd = new Random();
			String rdstr = String.valueOf(rd.nextInt(899999) + 100000);
			//
			rdstr = time + rdstr;
			return rdstr;
		} catch (Exception e) {
			throw new RuntimeException("生成主键失败");
		}

	}

	/**
	 * 生成UUID
	 *
	 * @return UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		return s.replaceAll("-", "").toUpperCase();
	}
	
	public static void main(String[] args) {
		 System.out.println(getUUID());
	}

}
