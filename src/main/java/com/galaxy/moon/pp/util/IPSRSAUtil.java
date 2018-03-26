package com.galaxy.moon.pp.util;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.controller.ips.UserRegisterController;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * create by zhangjun1 on 2018/2/9
 * 该类是对IPSCertUtil 和 IPSCryptoUtil使用类的封装。
 */
public class IPSRSAUtil {

    private static final String  ENCODING = "UTF-8";

    private static Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

    /**
     * 负责利用公钥进行加密， 和私钥进行签名
     * @param merchantID
     * @param operationType
     * @param reqStr
     * @return
     */
    public static  JSONObject genReqData(String merchantID, String operationType, String reqStr)  {
        //根据用户信息返回
        String sign = null;
        String reqDate = null;
        int keyLength = 0;
        int reserveSize = 11;
        byte[] encryptRSA = null;
        byte[] signDataBytes = null;
        PublicKey publicKey = null;
        try {
            // 加密---bank公钥
            publicKey = IPSCertUtil.getEncryptCertPublicKey();
            keyLength = getKeySize(publicKey);
            if (keyLength == 1024) {
                reserveSize = 0;
            }

            encryptRSA = IPSCryptoUtil.RSAEncrypt(reqStr.getBytes(), publicKey, keyLength, reserveSize, "RSA/ECB/PKCS1Padding");
            reqDate = new String(Base64.encodeBase64(encryptRSA), "UTF-8");

            // 加签---商户私钥
            signDataBytes = IPSCryptoUtil.digitalSign(IPSRSAUtil.reqSignStr(merchantID, operationType, reqDate), IPSCertUtil.getSignCertPrivateKey(), "SHA256withRSA");
            sign = new String(Base64.encodeBase64(signDataBytes), "UTF-8");
        } catch (Exception e) {
            logger.error("加密异常"+ e.getMessage());
            return null;
        }

        JSONObject result = new JSONObject();
        result.put(IPSCONSTANTS.SIGN_PARAM_merchantID, merchantID);
        result.put(IPSCONSTANTS.SIGN_PARAM_operationType, operationType);
        result.put(IPSCONSTANTS.SIGN_PARAM_REQUEST, reqDate);
        result.put(IPSCONSTANTS.SIGN_PARAM_SIGN, sign);
        return result;
    }

    /**
     * 解析响应的报文
     * @param merchantID
     * @param resultCode
     * @param resultMsg
     * @param sign
     * @param response
     * @return
     * @throws Exception
     */
    public static JSONObject analysisDepRespData(String merchantID, String resultCode, String resultMsg, String sign, String response) throws Exception {
        boolean flag = true;
        String reqDate = null;
        String msg = "验签失败！";
        // 签名域
        byte[] signDataBytes = null;
        byte[] ecryptRSA = null;
        int keyLength = 0;
        int reserveSize = 11;
        PublicKey publicKey = null;
        try {
            // 银行公钥验签
            publicKey= IPSCertUtil.getEncryptCertPublicKey();
            signDataBytes = Base64.decodeBase64(sign.getBytes(ENCODING));
            flag = IPSCryptoUtil.verifyDigitalSign(respSignStr(merchantID, resultCode, resultMsg, response), signDataBytes, publicKey, "SHA256withRSA");

            if (flag && !StringUtils.isEmpty(response)) {
                // 解密商户私钥解密
                keyLength = getKeySize(publicKey);
                if(keyLength==1024){
                    reserveSize=0;
                }
                ecryptRSA = IPSCryptoUtil.RSADecrypt(Base64.decodeBase64(response.getBytes()), IPSCertUtil.getSignCertPrivateKey(), keyLength, reserveSize,
                        "RSA/ECB/PKCS1Padding");
                reqDate = new String(ecryptRSA, ENCODING);
                if (reqDate.substring(0, 3).equals("01|")) {
                    reqDate = reqDate.substring(3);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + "验签异常！", e);
            msg = "验签异常！";
        }
        if (!flag) {
            throw new Exception(msg);
        }
        return JSONObject.parseObject(reqDate);
    }



    /**
     * 构建request请求
     * @param merchantID
     * @param operationType
     * @param req
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] reqSignStr(String merchantID, String operationType, String req) throws UnsupportedEncodingException {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(merchantID);
        sBuilder.append(operationType);
        sBuilder.append(req);
        return sBuilder.toString().getBytes("UTF-8");
    }

    /**
     * 该函数用于构建response函数
     * @param merchantID
     * @param resultCode
     * @param resultMsg
     * @param respDate
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] respSignStr(String merchantID, String resultCode, String resultMsg, String respDate) throws UnsupportedEncodingException {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(merchantID);
        sBuilder.append(resultCode);
        sBuilder.append(resultMsg);
        sBuilder.append(respDate);
        return sBuilder.toString().getBytes(ENCODING);
    }

    private static int getKeySize(PublicKey publicKey) throws Exception {
        String algorithm = publicKey.getAlgorithm(); // 获取算法
        KeyFactory keyFact = KeyFactory.getInstance(algorithm);
        BigInteger prime = null;
        if ("RSA".equals(algorithm)) { // 如果是RSA加密
            RSAPublicKeySpec keySpec = (RSAPublicKeySpec) keyFact.getKeySpec(publicKey, RSAPublicKeySpec.class);
            prime = keySpec.getModulus();
        } else if ("DSA".equals(algorithm)) { // 如果是DSA加密
            DSAPublicKeySpec keySpec = (DSAPublicKeySpec) keyFact.getKeySpec(publicKey, DSAPublicKeySpec.class);
            prime = keySpec.getP();
        }
        return prime.toString(2).length();
    }
}
