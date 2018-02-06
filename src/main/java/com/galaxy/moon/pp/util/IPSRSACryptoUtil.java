package com.galaxy.moon.pp.util;


import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Constants;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;


/**
 * create by zhangjun1 on 2018/1/8
 * <p>
 * 参考：http://www.importnew.com/14961.html
 */
public class IPSRSACryptoUtil {

    private static final Logger log = LoggerFactory.getLogger(IPSRSACryptoUtil.class);

    /**
     * 平台向dep请求的报文
     *
     * @param
     * @return
     */
    public static JSONObject genReqData(String merchantID, String operationType, String req) {
        String reqDate = null;
        String sign = null;
        try {
            // 加密---bank公钥
            reqDate = new String(Base64.getEncoder().encode(RSA.encrypt(IPSCertUtil.getEncryptCertPublicKey(), req)), "UTF-8");

            // 加签---商户私钥
            sign = new String(Base64.getEncoder().encode(RSA.signSHA256(IPSCertUtil.getSignCertPrivateKey(),
                    reqSignStr(merchantID, operationType, reqDate).getBytes(Constants.UTF_8_ENCODING))), Constants.UTF_8_ENCODING);
        } catch (Exception e) {
            log.error(e.getMessage() + "加密异常", e);
            return null;
        }
        JSONObject json = new JSONObject();
        json.put(IPSCONSTANTS.SIGN_PARAM_SIGN, sign);
        json.put(IPSCONSTANTS.SIGN_PARAM_REQUEST, reqDate);
        json.put(IPSCONSTANTS.SIGN_PARAM_operationType, operationType);
        json.put(IPSCONSTANTS.SIGN_PARAM_merchantID, merchantID);
        return json;
    }

    /**
     * 平台解析向dep响应的报文
     *
     * @param response 返回的报文
     * @return
     * @throws
     */
    public static JSONObject verifyRespData(String merchantID, String resultCode, String resultMsg, String sign, String response) throws Exception {
        boolean flag = true;
        String reqDate = null;
        String msg = "验签失败！";
        try {

            flag = RSA.verifySHA256(IPSCertUtil.getEncryptCertPublicKey(),
                    respSignStr(merchantID, resultCode, resultMsg, response).getBytes(Constants.UTF_8_ENCODING),
                    Hex.decodeHex(sign.toCharArray()));
            if (flag && !StringUtils.isEmpty(response)) {
                // 解密商户私钥解密
                reqDate = new String(RSA.decrypt(IPSCertUtil.getSignCertPrivateKey(), Base64.getDecoder().decode(response)), Constants.UTF_8_ENCODING);
            }
        } catch (Exception e) {
            log.error(e.getMessage() + "验签异常！", e);
            msg = "验签异常！";
        }
        if (!flag) {
            throw new Exception(msg);
        }
        //转化为JSONOBJECT
        return JSONObject.parseObject(reqDate);
    }

    private static String reqSignStr(String merchantID, String operationType, String req) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(merchantID);
        sBuilder.append(operationType);
        sBuilder.append(req);
        return sBuilder.toString();
    }

    private static String respSignStr(String merchantID, String resultCode, String resultMsg, String respDate) {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(merchantID);
        sBuilder.append(resultCode);
        sBuilder.append(resultMsg);
        sBuilder.append(respDate);
        return sBuilder.toString();
    }

}
