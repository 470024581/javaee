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
 * 公钥加密私钥解密的方式
 * 密钥长度160-16384（要求是8的整倍数）
 * Bouncy Castle实现
 * 1接收者构建密钥对，2公布密钥，3发送者使用公钥加密，4发送着发送加密数据，5接收者使用私钥解密
 */
public class ElGamal {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		BCElGamal();
	}
	
	public static void BCElGamal(){
		try {
			//公钥加密，私钥解密
			Security.addProvider(new BouncyCastleProvider());
			//1.初始化密钥
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
			
			//2.公钥加密
//			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(elGamalPublicKey.getEncoded());
//			KeyFactory keyFactory = KeyFactory.getInstance("ElGamal");
//			PublicKey publicKey = keyFactory.generatePublic(pkcs8EncodedKeySpec);
			Cipher cipher = Cipher.getInstance("ElGamal");
			cipher.init(Cipher.ENCRYPT_MODE, elGamalPublicKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("公钥加密 : " + Base64.encodeBase64String(result));
			
			//3.私钥解密
//			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(elGamalPrivateKey.getEncoded());
//			PrivateKey privateKey = keyFactory.generatePrivate(x509EncodedKeySpec);
			cipher.init(Cipher.DECRYPT_MODE, elGamalPrivateKey);
			result = cipher.doFinal(result);
			System.out.println("私钥解密 : " + new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
