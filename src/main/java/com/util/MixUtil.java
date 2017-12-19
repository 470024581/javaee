package com.util;

/***
 * 用于混淆各种号码,如手机号 ,银行卡号,身份证号
 * 
 * @author ylxu
 * @datetime 2016年3月9日 下午12:55:05
 */
public class MixUtil {
	//之后需要添加 手机号 ,银行卡号,身份证号 类型参数后,start及length该util给出
	/**
	 * 
	 * @param str	  需要混淆的字符串
	 * @param start   起始下标,从1开始
	 * @param length  中间需要混淆的字符长度
	 * @return
	 */
	public static String replaceSubString(String str, int start,int length) {
		String sub = "";
		String subTail = "";
		try {
			sub = str.substring(0, start-1);
			
			if(start -1+length >str.length()){
				length =str.length()-start+1;
			}else {
				subTail = str.substring(start -1+length);
			}
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				sb = sb.append("*");
			}
			sub += sb.toString();
			sub += subTail;
		} catch (Exception e) {
			throw new RuntimeException("生成混淆号码失败~");
		}
		return sub;
	}
	
	/**
	 * 
	 * @param str			需要混淆的字符串
	 * @param start			起始下标,从1开始
	 * @param backwards     倒数下标
	 * @return
	 */
	public static String replaceSub2String(String str, int start,int backwards) {
		String sub = "";
		String subTail = "";
		try {
			sub = str.substring(0, start-1);
			int length =str.length()-backwards-3;
			
			if(start -1+length >str.length()){
				length =str.length()-start+1;
			}else {
				subTail = str.substring(start -1+length);
			}
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length; i++) {
				sb = sb.append("*");
			}
			sub += sb.toString();
			sub += subTail;
		} catch (Exception e) {
			throw new RuntimeException("生成混淆号码失败~");
		}
		return sub;
	}
	
	public static String replaceDefaultBankCardString(String str) {
		return replaceSub2String(str, 5, 5);
	}
	
	public static void main(String[] args) {
		System.out.println(MixUtil.replaceSubString("陆仁贾",2,1));
		System.out.println(MixUtil.replaceSubString("陆仁贾",2,2));
		System.out.println(MixUtil.replaceSubString("陆仁贾",2,3));
		System.out.println("==============华丽的分隔符==================");
		System.out.println(MixUtil.replaceSubString("6225768677488047",5,8));
		System.out.println(MixUtil.replaceSubString("6225768677488047",13,8));
		
		System.out.println("==============华丽的分隔符==================");
		System.out.println(MixUtil.replaceSubString("310101200503017930",11,4));
		System.out.println(MixUtil.replaceDefaultBankCardString("31011030171110130"));
	}
}
