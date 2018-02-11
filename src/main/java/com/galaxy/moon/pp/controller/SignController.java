package com.galaxy.moon.pp.controller;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.netework.HttpManager;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.dto.UserRegisterDTO;
import com.galaxy.moon.pp.util.IPSCertUtil;
import com.galaxy.moon.pp.util.IPSCryptoUtil;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * create by zhangjun1 on 2018/1/9
 */
@RestController
@RequestMapping("/xhr")
public class SignController {

    @Autowired
    HttpManager httpManager;

    private static String ENCODING = "UTF-8";

    Logger logger = LoggerFactory.getLogger(SignController.class);

    @RequestMapping("/sign")
    public JSONObject sign(@RequestParam("merchantID") String merchantID,
                           @RequestParam("operationType") String operationType,
                           @RequestParam("request") String request) {
        return IPSRSAUtil.genReqData(merchantID, operationType, request);
    }

    @RequestMapping("/getSign")
    public JSONObject sign() {
        String merchantID = "1186570022";
        String operationType = "user.register";
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setMerBillNo("23235413");
        userRegisterDTO.setMerDate("2018-01-10");
        userRegisterDTO.setUserName("zj");
        userRegisterDTO.setUserType("1");
        userRegisterDTO.setUserRole("1");
        userRegisterDTO.setUserName("章的");
        userRegisterDTO.setRealName("哈哈");
        userRegisterDTO.setMobileNo("13016413998");
        userRegisterDTO.setBizType("1");
        userRegisterDTO.setEnterName("");
        userRegisterDTO.setIsAssureCom("1");
        userRegisterDTO.setWebUrl("http://127.0.0.1:8080/p2p-dep/test/p2pweb.html");
        userRegisterDTO.setS2SUrl("http://127.0.0.1:8080/p2p-dep/test/p2pweb.html");
        userRegisterDTO.setIdentNo("411527199210145036");
        String reqStr = JSONObject.toJSONString(userRegisterDTO);
        System.out.println(reqStr);
        System.out.println("==========");


        JSONObject result = IPSRSAUtil.genReqData(merchantID, operationType, reqStr);
        System.out.println(result);

        // begin to send request
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/x-www-form-urlencoded");

        headers.setAll(map);

        //使用RestTemplate向MPS发送消息时, 必须使用下面的写法。
        //MPS强制的提交方式是： POST， 表单， 参数提交方式
        MultiValueMap<String, String> req_form = new LinkedMultiValueMap<>();
        req_form.add(IPSCONSTANTS.SIGN_PARAM_merchantID, result.getString(IPSCONSTANTS.SIGN_PARAM_merchantID));
        req_form.add(IPSCONSTANTS.SIGN_PARAM_operationType, result.getString(IPSCONSTANTS.SIGN_PARAM_operationType));
        req_form.add(IPSCONSTANTS.SIGN_PARAM_REQUEST, result.getString(IPSCONSTANTS.SIGN_PARAM_REQUEST));
        req_form.add(IPSCONSTANTS.SIGN_PARAM_SIGN, result.getString(IPSCONSTANTS.SIGN_PARAM_SIGN));

        HttpEntity<?> request = new HttpEntity<>(req_form, headers);

        String url = "http://113.207.54.122:8011/p2p-dep/gateway.htm";

        //向消息中心件发送消息
        ResponseEntity<String> response = httpManager.restTemplate().postForEntity(url, request, String.class);
        System.out.println(response.getBody());
        return result;

    }


    @RequestMapping("/ips/getSign")
    public JSONObject Ipssign() {
        System.out.println("/ips/getSign请求");
        String merchantID = "1186570022";
        String operationType = "user.register";
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setMerBillNo("23235413");
        userRegisterDTO.setMerDate("2018-01-10");
        userRegisterDTO.setUserName("zj");
        userRegisterDTO.setUserType("1");
        userRegisterDTO.setUserRole("1");
        userRegisterDTO.setUserName("章的");
        userRegisterDTO.setRealName("哈哈");
        userRegisterDTO.setMobileNo("13016413998");
        userRegisterDTO.setBizType("1");
        userRegisterDTO.setEnterName("");
        userRegisterDTO.setIsAssureCom("1");
        userRegisterDTO.setWebUrl("http://127.0.0.1:8080/p2p-dep/test/p2pweb.html");
        userRegisterDTO.setS2SUrl("http://127.0.0.1:8080/p2p-dep/test/p2pweb.html");
        userRegisterDTO.setIdentNo("411527199210145036");
        String reqStr = JSONObject.toJSONString(userRegisterDTO);
        System.out.println(reqStr);
        System.out.println("==========");

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
            logger.error(e.getMessage() + "加密异常", e);
            return null;
        }

        JSONObject result = new JSONObject();
        result.put(IPSCONSTANTS.SIGN_PARAM_merchantID, merchantID);
        result.put(IPSCONSTANTS.SIGN_PARAM_operationType, "user.register");
        result.put(IPSCONSTANTS.SIGN_PARAM_REQUEST, reqDate);
        result.put(IPSCONSTANTS.SIGN_PARAM_SIGN, sign);


        // begin to send request
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/x-www-form-urlencoded");

        headers.setAll(map);

        //使用RestTemplate向MPS发送消息时, 必须使用下面的写法。
        //MPS强制的提交方式是： POST， 表单， 参数提交方式
        MultiValueMap<String, String> req_form = new LinkedMultiValueMap<>();
        req_form.add(IPSCONSTANTS.SIGN_PARAM_merchantID, result.getString(IPSCONSTANTS.SIGN_PARAM_merchantID));
        req_form.add(IPSCONSTANTS.SIGN_PARAM_operationType, result.getString(IPSCONSTANTS.SIGN_PARAM_operationType));
        req_form.add(IPSCONSTANTS.SIGN_PARAM_REQUEST, result.getString(IPSCONSTANTS.SIGN_PARAM_REQUEST));
        req_form.add(IPSCONSTANTS.SIGN_PARAM_SIGN, result.getString(IPSCONSTANTS.SIGN_PARAM_SIGN));

        HttpEntity<?> request = new HttpEntity<>(req_form, headers);

        String url = "http://113.207.54.122:8011/p2p-dep/gateway.htm";

        //向消息中心件发送消息
        ResponseEntity<String> response = httpManager.restTemplate().postForEntity(url, request, String.class);
        System.out.println(response.getBody());
        return result;

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
