package test.algorithm.encryption.symmetric;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 *	对称加密算法： 加密和解密是同一个密钥，加解密的过程是相反的
 *	DES:Data Encryption Standard 数据加密标准
 *	密钥长度：64位
 *	缺点：1.违反柯克霍夫原则。2.安全问题
 *
 **/
public class Des {
	
	private static final String src = "lianglong";
	
	public static void main(String[] args) {
		jdkDES();
		bcDES();
	}
	
	public static void jdkDES(){
		try {
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			//初始化密钥长度
			keyGenerator.init(56);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//key转换
			DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk des encrypt : " + Hex.encodeHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdk des decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void bcDES(){
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			//生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			//初始化密钥长度
			keyGenerator.init(56);
			SecretKey secretKey =  keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//key转换
			DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES","BC");
			Key convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc des encrypt : " + Hex.encodeHexString(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("bc des decrypt : " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
