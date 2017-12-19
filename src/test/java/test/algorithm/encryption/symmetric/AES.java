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
 *	AES��Advanced Encryption Standard�߼����ܱ�׼��Ŀǰʹ����࣬��Ч�ʺͰ�ȫ���϶��Ƚϸ�
 *	��Կ���ȣ�128-256��32�ı�����
 *	���裺1.������Կ��2��������Կ��3��ʹ����Կ�����ݼ��ܣ�4.���ͼ������ݣ�5.ʹ����Կ�����ݽ���
 *	����ʹ���У����ܺͽ��ܶ�������ͬһ���ģ�������Կһ��������Լ���ã������Ǽ��ܺ�ͨ�����紫�䣨�б��ػ�Ŀ��ܣ�
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
	        Cipher cipher = Cipher.getInstance("AES");// ����������   
	        byte[] byteContent = str.getBytes("utf-8");  
	        cipher.init(Cipher.ENCRYPT_MODE, key);// ��ʼ��   
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
			//����key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			//��ʼ����Կ����
			keyGenerator.init(128);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//keyת��
			Key key = new SecretKeySpec(bytesKey,"AES");
			
			//����
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));
			
			//����
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
			
			//����key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES","BC");
			//��ʼ����Կ����
			keyGenerator.init(128);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//keyת��
			Key key = new SecretKeySpec(bytesKey,"AES");
			
			//����
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc aes encrypt : " + Base64.encodeBase64String(result));
			
			//����
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("bc aes decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
