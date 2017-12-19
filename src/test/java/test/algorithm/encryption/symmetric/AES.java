package test.algorithm.encryption.symmetric;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 *	AES（Advanced Encryption Standard高级加密标准）目前使用最多，在效率和安全性上都比较高
 *	密钥长度：128-256（32的倍数）
 *	步骤：1.构建密钥，2。公布密钥，3。使用密钥对数据加密，4.发送加密数据，5.使用密钥对数据解密
 *	正常使用中，加密和解密都不是在同一方的，所以密钥一般是事先约定好，或者是加密后通过网络传输（有被截获的可能）
 **/
public class AES {
	
	private static String src = "lianglong";
	
	static String str = "{\"Amount\":350,\"PdtType\":\"M903\",\"SerialNo\":\"JF14405609176117p640v8\",\"MerId\":\"403110149009176\",\"PdtNum\":\"1\"}";

	static String keyStr = "P9y/q06ZY2779vTbLf6P8A==";
	
	public static void main(String[] args) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");  
	        kgen.init(128, new SecureRandom(keyStr.getBytes()));  
	        SecretKey secretKey = kgen.generateKey();  
	        byte[] enCodeFormat = secretKey.getEncoded();  
	        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
	        Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
	        byte[] byteContent = str.getBytes("utf-8");  
	        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
	        byte[] result = cipher.doFinal(byteContent);
	        System.out.println("jdk aes encrypt : " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		jdkAES();
//		bcAES();
	}
	
	public static void jdkAES(){
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			//初始化密钥长度
			keyGenerator.init(128);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//key转换
			Key key = new SecretKeySpec(bytesKey,"AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("jdk aes decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void bcAES() {
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES","BC");
			//初始化密钥长度
			keyGenerator.init(128);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//key转换
			Key key = new SecretKeySpec(bytesKey,"AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc aes encrypt : " + Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("bc aes decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
