package test.algorithm.encryption.base64;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 	柯克霍夫原则：密码系统应该就算被所有人知道系统的运作步骤，仍然是安全的
 * 	定义：基于64个字符的编码算法（A-Z，a-z，0-9，+，/，=）
 *	base64应用场景：email、密钥、证书文件
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
	 *	JDK的实现 
	 **/
	public static void jdkBase64() {
		try {
			//加密
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("encode : "+encode);
			
			//解密
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] decode =  decoder.decodeBuffer(encode);
			System.out.println("decode : " + new String(decode));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *	Commons Codec的实现 
	 **/
	public static void commonsCodesBase64(){
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		System.out.println("encode : " + new String(encodeBytes));
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("decode : " + new String(decodeBytes));
	}
	
	/**
	 *	Bouncy Castle的实现 
	 **/
	public static void bouncyCastleBase64(){
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode : " + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("decode : " + new String(decodeBytes));
	}

}
