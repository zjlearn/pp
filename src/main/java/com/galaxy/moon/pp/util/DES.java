package com.galaxy.moon.pp.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * DES
 *
 * @author levis
 * @version 1.0 13-6-5
 */
@SuppressWarnings({ "restriction" })
public class DES {

    /**
     * encrypt3DES
     *
     * @param encryptString
     * @param encryptKey
     * @param iv
     * @return
     */
    public static String encrypt3DES(String encryptString, String encryptKey,String iv)  {
        try{
            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes("UTF-8"), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
            byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));
            return new BASE64Encoder().encode(encryptedData);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    /**
     * decrypt3DES
     *
     * @param decryptString
     * @param decryptKey
     * @param iv
     * @return
     */
    public static String decrypt3DES(String decryptString, String decryptKey,String iv) {
        try{
            byte[] byteMi =new BASE64Decoder().decodeBuffer(decryptString);
            IvParameterSpec zeroIv = new IvParameterSpec(iv.getBytes("UTF-8"));
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes("UTF-8"), "DESede");
            Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte decryptedData[] = cipher.doFinal(byteMi);
            return new String(decryptedData,"UTF-8");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    public static void main(String args[]){
    	String decryptKey = "r0uScmDuH5FLO37AJV2FN72J";
    	String iv = "1eX24DCe";
    	String decryptString = "6Czok7lRMbqViyww7qJt4irpxs8lFUHDEolqoFZZHIcqG/+w5EM+1kohuGzCjDHYrnv4ob3xud8fa//gwspT5HzoDPxJaKDJbjRhCGnsFXnuenOeabjIuOI0ExzQkO75QAHPmUncSTYxS+oWqxMBBsDCl93K2wYnna9PMuzfxhgzpnij86qIUVPrNeYSK/Zqzv2pYPXln3IJWbhXK2F+SOb8TgsMEe1XeTQWKkzqvzI/Sj6qdBGcb4qqTAZjy+ITGwln+6gvYUu3JAUV+Esw6QvTDywlIAPLUsGshCgPsIHI66VgfvgmFNTfCBTG8L9Bwo31nzk7UInnCBEwSBY7k3kuBOQDJaH5kD8lduglt4ymvAkkKPvrAg2596AEqb/uYWhHIv1Rtvwo87bpT0jkbZJ4Qxx2EjHl2FeYtM6CzxOxUdyVVKImGi5fZHOBiKRvdGkaDFebxd0=";
    	//加密
    	System.out.println("加密："+decrypt3DES(decryptString,decryptKey,iv));
    	//解密
    	System.out.println("解密："+encrypt3DES(decrypt3DES(decryptString,decryptKey,iv),decryptKey,iv).replaceAll("\n", ""));
    	
    }
}
