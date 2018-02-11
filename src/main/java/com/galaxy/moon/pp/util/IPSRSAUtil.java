package com.galaxy.moon.pp.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.security.PublicKey;

import static sun.security.util.KeyUtil.getKeySize;

/**
 * create by zhangjun1 on 2018/2/9
 */
public class IPSRSAUtil {

    private static final String  ENCODING = "UTF-8";

    public static  JSONObject genReqData(String merchantID, String operationType, String reqStr)  {
        JSONObject result = new JSONObject();
        // 加密---bank公钥
        PublicKey publicKey = IPSCertUtil.getEncryptCertPublicKey();
        int keyLength = getKeySize(publicKey);
        int reserveSize =0;
        if (keyLength == 1024) {
            reserveSize = 0;
        }

        byte [] encryptRSA = new byte[0];
        try {
            encryptRSA = IPSCryptoUtil.RSAEncrypt(reqStr.getBytes(), publicKey, keyLength, reserveSize, "RSA/ECB/PKCS1Padding");
            String reqDate = new String(Base64.encodeBase64(encryptRSA), "UTF-8");

            // 加签---商户私钥
            byte [] signDataBytes = IPSCryptoUtil.digitalSign(reqSignStr(merchantID, operationType, reqDate), IPSCertUtil.getSignCertPrivateKey(), "SHA256withRSA");
            String sign = new String(Base64.encodeBase64(signDataBytes), "UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // todo set value
        return result;
    }

    public static byte[] reqSignStr(String merchantID, String operationType, String req) throws UnsupportedEncodingException {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(merchantID);
        sBuilder.append(operationType);
        sBuilder.append(req);
        return sBuilder.toString().getBytes("UTF-8");
    }

    public static byte[] respSignStr(String merchantID, String resultCode, String resultMsg, String respDate) throws UnsupportedEncodingException {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(merchantID);
        sBuilder.append(resultCode);
        sBuilder.append(resultMsg);
        sBuilder.append(respDate);
        return sBuilder.toString().getBytes(ENCODING);
    }
}
