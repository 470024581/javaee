package test.algorithm.encryption.symmetric;

import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *	3DES ��des�������� ����Ч�ʽϵͣ�
 **/
public class Des3 {
	
	private static final String src = "lianglong";

	public static void main(String[] args) {
		jdk3DES();
		bc3DES();
	}
	
	private static void jdk3DES(){
		try {
			//����key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			//��ʼ����Կ����
//			keyGenerator.init(168);
			keyGenerator.init(new SecureRandom());
			
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//keyת��
			DESedeKeySpec desedeKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			Key convertSecretKey = factory.generateSecret(desedeKeySpec);
			
			//����
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk 3des encrypt : " + Hex.encodeHexString(result));
			
			//����
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdk 3des decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void bc3DES(){
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			//����key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			//��ʼ����Կ����
			keyGenerator.init(112);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//keyת��
			DESedeKeySpec desedeKeySpec = new DESedeKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede","BC");
			Key convertSecretKey = factory.generateSecret(desedeKeySpec);
			
			//����
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc 3des encrypt : " + Hex.encodeHexString(result));
			
			//����
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("bc 3des decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
