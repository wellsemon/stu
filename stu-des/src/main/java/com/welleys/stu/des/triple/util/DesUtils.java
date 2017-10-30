package com.welleys.stu.des.triple.util;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.SunJCE;

public class DesUtils {
	private static String strDefaultKey = "sungard123";
	private Cipher encryptCipher;
	private Cipher decryptCipher;

	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;

		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; ++i) {
			int intTmp = arrB[i];

			intTmp += 12;
			while (intTmp < 0) {
				intTmp += 256;
			}

			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i += 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[(i / 2)] = (byte) (Integer.parseInt(strTmp, 16) - 12);
		}
		return arrOut;
	}

	public DesUtils() throws Exception {
		this(strDefaultKey);
	}

	public DesUtils(String strKey) throws Exception {
		this.encryptCipher = null;

		this.decryptCipher = null;

		Security.addProvider(new SunJCE());
		Key key = getKey(strKey.getBytes());

		this.encryptCipher = Cipher.getInstance("DES");
		this.encryptCipher.init(1, key);

		this.decryptCipher = Cipher.getInstance("DES");
		this.decryptCipher.init(2, key);
	}

	public byte[] encrypt(byte[] arrB) throws Exception {
		return this.encryptCipher.doFinal(arrB);
	}

	public String encrypt(String strIn) {
		String s = null;
		try {
			s = byteArr2HexStr(encrypt(strIn.getBytes()));
		} catch (Exception e) {
			return null;
		}
		return s;
	}

	public byte[] decrypt(byte[] arrB) throws Exception {
		return this.decryptCipher.doFinal(arrB);
	}

	public String decrypt(String strIn) {
		String s = null;
		try {
			s = new String(decrypt(hexStr2ByteArr(strIn)));
		} catch (Exception e) {
			return null;
		}
		return s;
	}

	private Key getKey(byte[] arrBTmp) throws Exception {
		byte[] arrB = new byte[8];

		for (int i = 0; (i < arrBTmp.length) && (i < arrB.length); ++i) {
			arrB[i] = arrBTmp[i];
		}

		Key key = new SecretKeySpec(arrB, "DES");

		return key;
	}

	public static void main(String[] args) {
		try {
			// String test = "��df#@$";
			String test = "hello";
			final byte[] keyBytes = {0x11, 0x22, 0x4F, 0x58, (byte)0x88, 0x10, 0x40, 0x38
                    , 0x28, 0x25, 0x79, 0x51, (byte)0xCB, (byte)0xDD, 0x55, 0x66
                    , 0x77, 0x29, 0x74, (byte)0x98, 0x30, 0x40, 0x36, (byte)0xE2};
			String keyStr = byteArr2HexStr(keyBytes);
			//DesUtils des = new DesUtils("sungard");
			DesUtils des = new DesUtils(keyStr);
			System.out.println("����ǰ���ַ���" + test);
			System.out.println("���ܺ���ַ���" + des.encrypt(test));
			System.out.println("���ܺ���ַ���" + des.decrypt(des.encrypt(test)));

			// System.out.println("���ܺ���ַ���" +
			// des.decrypt("632e352018f1dc40e6e5eafe9772c8871"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}