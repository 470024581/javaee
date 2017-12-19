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
 *	�ǶԳƼ����㷨���߼���˫���գ���˽Կ
 *	DH��Diffie-Hellman����Կ�����㷨����Կ���ȣ�512-1024��64�ı�������Ĭ��1024
 *	RSA��3���˵����ϣ��������ӷֽ⣬���������ݼ��ܺ�����ǩ��
 *	ElGamal������ɢ����
 *	ECC��Elliptical Curve Cryptography����Բ���߼���
 *	
 **/
public class DH {
	
	private static String src = "lianglong";

	public static void main(String[] args) {
		jdkDH();
	}
	
	public static void jdkDH(){
		try {
			//���������������Ĳ�����1��2������ͬһ�����֡�
			//1.��ʼ�����ͷ���Կ
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
			keyPairGenerator.initialize(512);
			KeyPair senderKeyPair = keyPairGenerator.generateKeyPair();
			//���ͷ���Կ�����͸����շ������磬�ļ�����������ʽ��
			byte[] keyEncode = senderKeyPair.getPublic().getEncoded();
			
			//2.��ʼ�����շ���Կ
			KeyFactory keyFactory = KeyFactory.getInstance("DH");
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyEncode);
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			DHParameterSpec dhParameterSpec = ((DHPublicKey)publicKey).getParams();
			keyPairGenerator.initialize(dhParameterSpec);
			KeyPair receiverKeyPair = keyPairGenerator.generateKeyPair();
			PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
			byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();
			
			//3.��Կ����
			KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
			keyAgreement.init(receiverKeyPair.getPrivate());
			keyAgreement.doPhase(receiverKeyPair.getPublic(), true);
			SecretKey receiverDesKey = keyAgreement.generateSecret("DES");
			
			KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
			//��������
			x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
			PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
			keyAgreement.init(senderKeyPair.getPrivate());
			keyAgreement.doPhase(senderPublicKey, true);
			SecretKey senderDesKey = keyAgreement.generateSecret("DES");
			if(receiverDesKey.equals(senderDesKey)){
				System.out.println("��Կ��ͬ��");
			}
			
			//4.����
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk dh encrypt : " + Base64.encodeBase64String(result));
			
			//5.����
			cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
			result = cipher.doFinal(result);
			System.out.println("jdk dh decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
