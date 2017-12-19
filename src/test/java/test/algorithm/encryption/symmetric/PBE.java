package test.algorithm.encryption.symmetric;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 	PBE(Password Based Encryption)基于口令加密
 * 	综合性的对称加密算法
 * 	步骤：1.构建口令，2.公布口令，3.构建盐，4.使用口令、盐对数据加密，5.发送盐和加密数据，6.使用口令、盐对数据解密
 */
public class PBE {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		jdkPBE();
	}
	
	public static void jdkPBE() {
		try {
			//初始化盐：扰码
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);
			
			//口令与密钥
			String password = "password";
			PBEKeySpec pbeKey = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key = factory.generateSecret(pbeKey);
			
			//加密
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk pbe encrypt : " + Base64.encodeBase64String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
			result = cipher.doFinal(result);
			System.out.println("jdk pbe decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
