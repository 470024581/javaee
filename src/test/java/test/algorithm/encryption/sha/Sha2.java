package test.algorithm.encryption.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description 数字签名（不可逆算法）
 *              由于md5和sha1有可能很快被破解风险，现在多使用sha2（SHA-224、SHA-256、SHA-384
 *              ，和SHA-512并称为SHA-2）
 * @author lianglong
 */
public class Sha2 {

	// 摘要长度64
	private static String Encrypt_256 = "SHA-256";
	// 摘要长度96
	private static String Encrypt_384 = "SHA-384";
	// 摘要长度128
	private static String Encrypt_512 = "SHA-512";

	/**
	 * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
	 * 
	 * @param strSrc
	 *            要加密的字符串
	 * @param encName
	 *            加密类型
	 * @return
	 */
	public static String Encrypt(String strSrc, String encName) {
		if (strSrc == null || strSrc.equals("")) {
			return null;
		}
		try {
			if (encName == null || encName.equals("")) {
				encName = Encrypt_256;
			}
			MessageDigest md = MessageDigest.getInstance(encName);
			md.update(strSrc.getBytes());
			String strDes = bytes2Hex(md.digest()); // to HexString
			return strDes;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;
		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static void main(String args[]) {
		String str = "f376606f09af71da7125975a71263b6b"; //872189
		String s256 = Sha2.Encrypt(str, Encrypt_256);
		System.out.println(s256);
		System.out.println(s256.length());
		String s384 = Sha2.Encrypt(str, Encrypt_384);
		System.out.println(s384);
		System.out.println(s384.length());
		String s512 = Sha2.Encrypt(str, Encrypt_512);
		System.out.println(s512);
		System.out.println(s512.length());
	}

}
