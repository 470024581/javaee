package test.algorithm.encryption.asymmetric;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * ��Կ����˽Կ���ܵķ�ʽ
 * ��Կ����160-16384��Ҫ����8����������
 * Bouncy Castleʵ��
 * 1�����߹�����Կ�ԣ�2������Կ��3������ʹ�ù�Կ���ܣ�4�����ŷ��ͼ������ݣ�5������ʹ��˽Կ����
 */
public class ElGamal {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		BCElGamal();
	}
	
	public static void BCElGamal(){
		try {
			//��Կ���ܣ�˽Կ����
			Security.addProvider(new BouncyCastleProvider());
			//1.��ʼ����Կ
			AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ElGamal");
			algorithmParameterGenerator.init(256);
			AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
			DHParameterSpec dhParameterSpec = (DHParameterSpec) algorithmParameters.getParameterSpec(DHParameterSpec.class);
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ElGamal");
			keyPairGenerator.initialize(dhParameterSpec, new SecureRandom());
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			ElGamalPublicKey elGamalPublicKey = (ElGamalPublicKey) keyPair.getPublic();
			ElGamalPrivateKey elGamalPrivateKey = (ElGamalPrivateKey) keyPair.getPrivate();
//			PublicKey elGamalPublicKey = keyPair.getPublic();
//			PrivateKey elGamalPrivateKey = keyPair.getPrivate();
			System.out.println("public key : "+elGamalPublicKey);
			System.out.println("private key : "+elGamalPrivateKey);
			
			//2.��Կ����
//			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(elGamalPublicKey.getEncoded());
//			KeyFactory keyFactory = KeyFactory.getInstance("ElGamal");
//			PublicKey publicKey = keyFactory.generatePublic(pkcs8EncodedKeySpec);
			Cipher cipher = Cipher.getInstance("ElGamal");
			cipher.init(Cipher.ENCRYPT_MODE, elGamalPublicKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("��Կ���� : " + Base64.encodeBase64String(result));
			
			//3.˽Կ����
//			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(elGamalPrivateKey.getEncoded());
//			PrivateKey privateKey = keyFactory.generatePrivate(x509EncodedKeySpec);
			cipher.init(Cipher.DECRYPT_MODE, elGamalPrivateKey);
			result = cipher.doFinal(result);
			System.out.println("˽Կ���� : " + new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
