package com.welleys.stu.des.triple.basic;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DES3 {
	private static final String ALGORITHM = "DESede";

	public static byte[] encryptMode(byte[] keybyte, byte[] src) {
		SecretKey key = new SecretKeySpec(keybyte, ALGORITHM);
		Cipher ciper;
		try {
			ciper = Cipher.getInstance(ALGORITHM);
			ciper.init(Cipher.ENCRYPT_MODE, key);
			return ciper.doFinal(src);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static byte[] decryptMode(byte[] keybyte, byte[] src) {
		SecretKey key = new SecretKeySpec(keybyte, ALGORITHM);
		Cipher ciper;
		try {
			ciper = Cipher.getInstance(ALGORITHM);
			ciper.init(Cipher.DECRYPT_MODE, key);
			return ciper.doFinal(src);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;

	}

	//  ת����ʮ�������ַ���
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
			if (n < b.length - 1) {
				hs = hs + ":";
			}
		}
		return hs.toUpperCase();
	}

	public static void main(String[] args) {
		 // ����°�ȫ�㷨,�����JCE��Ҫ������ӽ�ȥ
		 Security.addProvider(new com.sun.crypto.provider.SunJCE());
		 final byte[] keyBytes = {0x11, 0x22, 0x4F, 0x58, (byte) 0x88, 0x10,
		 0x40, 0x38, 0x28, 0x25, 0x79, 0x51, (byte) 0xCB, (byte) 0xDD,
		 0x55, 0x66, 0x77, 0x29, 0x74, (byte) 0x98, 0x30, 0x40, 0x36,
		 (byte) 0xE2}; // 24�ֽڵ���Կ
		 
		 System.out.println(keyBytes.length);
		 System.out.println(byte2hex(keyBytes));
		 
		 String szSrc = "This is a 3DES test. ����";
		 System.out.println("����ǰ���ַ���:" + szSrc);
		 
		 byte[] encoded = encryptMode(keyBytes, szSrc.getBytes());
		 System.out.println("���ܺ���ַ���:" + new String(encoded));
		 
		 byte[] srcBytes = decryptMode(keyBytes, encoded);
		 System.out.println("���ܺ���ַ���:" + (new String(srcBytes)));
		 }
}
