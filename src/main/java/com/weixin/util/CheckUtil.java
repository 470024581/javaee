package com.weixin.util;

import java.security.MessageDigest;
import java.util.Arrays;

import org.apache.commons.lang.StringUtils;

/**
 * @description 
 * @author lianglong
 */
public class CheckUtil {
	
	public static final String token = "lianglong";
	
	public static boolean checkSignature(String signature, String timestamp, String nonce){
		String [] arr = new String[]{token, timestamp, nonce};
		// 排序
 		Arrays.sort(arr);
 		// 拼接字符串
 		StringBuffer sb = new StringBuffer();
 		for(String str : arr){
 			sb.append(str);
 		}
 		// sha1加密
 		String temp = getSha1(sb.toString());
		return temp.equals(signature);
	}

	public static String getSha1(String str) {
		if(StringUtils.isBlank(str)){
			return null;
		}
		char[] Digit = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c',
                'd', 'e', 'f'};
		try {
			MessageDigest md = MessageDigest.getInstance("sha1");
			md.update(str.getBytes("UTF-8"));
			byte[] mds = md.digest();
			int j = mds.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for(int i=0; i<j; i++){
				byte byte1 = mds[i];
				buf[k++] = Digit[byte1 >>> 4 & 0xf];
				buf[k++] = Digit[byte1 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
