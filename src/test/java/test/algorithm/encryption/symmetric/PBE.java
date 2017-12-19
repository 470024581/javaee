package test.algorithm.encryption.symmetric;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 * 	PBE(Password Based Encryption)���ڿ������
 * 	�ۺ��ԵĶԳƼ����㷨
 * 	���裺1.�������2.�������3.�����Σ�4.ʹ�ÿ���ζ����ݼ��ܣ�5.�����κͼ������ݣ�6.ʹ�ÿ���ζ����ݽ���
 */
public class PBE {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		jdkPBE();
	}
	
	public static void jdkPBE() {
		try {
			//��ʼ���Σ�����
			SecureRandom random = new SecureRandom();
			byte[] salt = random.generateSeed(8);
			
			//��������Կ
			String password = "password";
			PBEKeySpec pbeKey = new PBEKeySpec(password.toCharArray());
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
			Key key = factory.generateSecret(pbeKey);
			
			//����
			PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
			Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
			cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk pbe encrypt : " + Base64.encodeBase64String(result));
			
			//����
			cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
			result = cipher.doFinal(result);
			System.out.println("jdk pbe decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
