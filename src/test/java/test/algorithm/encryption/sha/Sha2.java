package test.algorithm.encryption.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description ����ǩ�����������㷨��
 *              ����md5��sha1�п��ܺܿ챻�ƽ���գ����ڶ�ʹ��sha2��SHA-224��SHA-256��SHA-384
 *              ����SHA-512����ΪSHA-2��
 * @author lianglong
 */
public class Sha2 {

	// ժҪ����64
	private static String Encrypt_256 = "SHA-256";
	// ժҪ����96
	private static String Encrypt_384 = "SHA-384";
	// ժҪ����128
	private static String Encrypt_512 = "SHA-512";

	/**
	 * ���ַ�������,�����㷨ʹ��MD5,SHA-1,SHA-256,Ĭ��ʹ��SHA-256
	 * 
	 * @param strSrc
	 *            Ҫ���ܵ��ַ���
	 * @param encName
	 *            ��������
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
