package com.welleys.stu.des.triple.basic;

import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ThreeDes {

private static final String Algorithm = "DESede"; //���� �����㷨,���� DES,DESede,Blowfish
    
    //keybyteΪ������Կ������Ϊ24�ֽ�
    //srcΪ�����ܵ����ݻ�������Դ��
    public static byte[] encryptMode(byte[] keybyte, byte[] src) {
       try {
            //������Կ
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            //����
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    //keybyteΪ������Կ������Ϊ24�ֽ�
    //srcΪ���ܺ�Ļ�����
    public static byte[] decryptMode(byte[] keybyte, byte[] src) {      
    try {
            //������Կ
            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            //����
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    //ת����ʮ�������ַ���
    public static String byte2hex(byte[] b) {
        String hs="";
        String stmp="";

        for (int n=0;n<b.length;n++) {
            stmp=(Integer.toHexString(b[n] & 0XFF));
            if (stmp.length()==1) hs=hs+"0"+stmp;
            else hs=hs+stmp;
            if (n<b.length-1)  hs=hs+":";
        }
        return hs.toUpperCase();
    }
    
    public static void main(String[] args)
    {
        //����°�ȫ�㷨,�����JCE��Ҫ������ӽ�ȥ
        Security.addProvider(new com.sun.crypto.provider.SunJCE());

        final byte[] keyBytes = {0x11, 0x22, 0x4F, 0x58, (byte)0x88, 0x10, 0x40, 0x38
                               , 0x28, 0x25, 0x79, 0x51, (byte)0xCB, (byte)0xDD, 0x55, 0x66
                               , 0x77, 0x29, 0x74, (byte)0x98, 0x30, 0x40, 0x36, (byte)0xE2};    //24�ֽڵ���Կ
        //String szSrc = "This is a 3DES test. ����";
        String szSrc = "hello";
        
        System.out.println("����ǰ���ַ���:" + szSrc);
        
        byte[] encoded = encryptMode(keyBytes, szSrc.getBytes());
        System.out.println("���ܺ���ַ���:" + new String(encoded));
        
        byte[] srcBytes = decryptMode(keyBytes, encoded);
        System.out.println("���ܺ���ַ���:" + (new String(srcBytes)));
    }

}