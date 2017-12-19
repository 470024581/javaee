package test.algorithm.encryption.asymmetric;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
	
/**
 * 	��Կ����512-65536��Ҫ����64����������
 *	Ψһ�㷺���ܲ�ʵ�� 
 *	���ݼ���&����ǩ��
 *	��Կ���ܡ�˽Կ����-��Կ�������ݣ����ͼ������ݣ�ʹ��˽Կ����
 *	˽Կ���ܡ���Կ����-˽Կ�������ݣ����ͼ������ݣ�ʹ�ù�Կ����
 **/
public class RSA {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		jdkRSA();
	}
	
	public static void jdkRSA() {
		try {
			//1.��ʼ����Կ
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
			System.out.println("public key : "+rsaPublicKey);
			System.out.println("private key : "+rsaPrivateKey);
			
			//2.˽Կ���ܡ���Կ����--����
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("˽Կ���ܡ���Կ����--���� : " + Base64.encodeBase64String(result));
			
			//3.˽Կ���ܡ���Կ����--����
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			result = cipher.doFinal(result);
			System.out.println("˽Կ���ܡ���Կ����--���� : " + new String(result));
			
			
			//4.��Կ���ܡ�˽Կ����--����
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			result = cipher.doFinal(src.getBytes());
			System.out.println("��Կ���ܡ�˽Կ����--���� : " + Base64.encodeBase64String(result));
			
			//5.��Կ���ܡ�˽Կ����--����
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			result = cipher.doFinal(result);
			System.out.println("��Կ���ܡ�˽Կ����--���� : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
