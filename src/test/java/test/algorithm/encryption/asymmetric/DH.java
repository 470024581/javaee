package test.algorithm.encryption.asymmetric;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;

/**
 *	非对称加密算法：高级，双保险，公私钥
 *	DH（Diffie-Hellman）密钥交换算法，密钥长度：512-1024（64的倍数），默认1024
 *	RSA（3个人的姓氏）基于因子分解，可用于数据加密和数字签名
 *	ElGamal基于离散对数
 *	ECC（Elliptical Curve Cryptography）椭圆曲线加密
 *	
 **/
public class DH {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		jdkDH();
	}
	
	public static void jdkDH(){
		try {
			//整个流程是两方的操作，1和2不会在同一方出现。
			//1.初始化发送方密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
			keyPairGenerator.initialize(512);
			KeyPair senderKeyPair = keyPairGenerator.generateKeyPair();
			//发送方公钥，发送给接收方（网络，文件。。。等形式）
			byte[] keyEncode = senderKeyPair.getPublic().getEncoded();
			
			//2.初始化接收方密钥
			KeyFactory keyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyEncode);
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			DHParameterSpec dhParameterSpec = ((DHPublicKey)publicKey).getParams();
			keyPairGenerator.initialize(dhParameterSpec);
			KeyPair receiverKeyPair = keyPairGenerator.generateKeyPair();
			PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
			byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();
			
			//3.密钥构建
			KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
			keyAgreement.init(receiverKeyPair.getPrivate());
			keyAgreement.doPhase(receiverKeyPair.getPublic(), true);
			SecretKey receiverDesKey = keyAgreement.generateSecret("DES");
			
			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			//从新生成
			x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
			keyAgreement.init(senderKeyPair.getPrivate());
			keyAgreement.doPhase(senderPublicKey, true);
			SecretKey senderDesKey = keyAgreement.generateSecret("DES");
			if(receiverDesKey.equals(senderDesKey)){
				System.out.println("密钥相同！");
			}
			
			//4.加密
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk dh encrypt : " + Base64.encodeBase64String(result));
			
			//5.解密
			cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
			result = cipher.doFinal(result);
			System.out.println("jdk dh decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
