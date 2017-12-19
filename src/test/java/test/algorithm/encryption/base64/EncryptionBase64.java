package test.algorithm.encryption.base64;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 	�¿˻���ԭ������ϵͳӦ�þ��㱻������֪��ϵͳ���������裬��Ȼ�ǰ�ȫ��
 * 	���壺����64���ַ��ı����㷨��A-Z��a-z��0-9��+��/��=��
 *	base64Ӧ�ó�����email����Կ��֤���ļ�
 * 
 **/
public class EncryptionBase64 {

	private static String src = "lianglong -- do";
	
	public static void main(String[] args) {
		jdkBase64();
		commonsCodesBase64();
		bouncyCastleBase64();
	}
	
	/**
	 *	JDK��ʵ�� 
	 **/
	public static void jdkBase64() {
		try {
			//����
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("encode : "+encode);
			
			//����
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decode =  decoder.decodeBuffer(encode);
			System.out.println("decode : " + new String(decode));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	Commons Codec��ʵ�� 
	 **/
	public static void commonsCodesBase64(){
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		System.out.println("encode : " + new String(encodeBytes));
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("decode : " + new String(decodeBytes));
	}
	
	/**
	 *	Bouncy Castle��ʵ�� 
	 **/
	public static void bouncyCastleBase64(){
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode : " + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("decode : " + new String(decodeBytes));
	}

}
