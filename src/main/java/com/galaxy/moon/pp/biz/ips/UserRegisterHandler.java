package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.controller.ips.UserRegisterController;
import com.galaxy.moon.pp.model.dto.UserRegisterDTO;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSCertUtil;
import com.galaxy.moon.pp.util.IPSCryptoUtil;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.UUID;

/**
 * 负责ips的用户注册类
 */
@Component
public class UserRegisterHandler {
    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

    public Result userRegister(JSONObject jsonObject) {

        String realName = jsonObject.getString("name");
        String idCard = jsonObject.getString("idCard");
        System.out.println("开户的姓名是：" + realName);
        System.out.println("开户的身份证号是： " + idCard);

        String Id = UUID.randomUUID().toString();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setMerBillNo("23235413");
        userRegisterDTO.setMerDate("2018-01-10");
        userRegisterDTO.setUserName(realName);
        userRegisterDTO.setUserType("1");
        userRegisterDTO.setUserRole("1");
        userRegisterDTO.setRealName(realName);
        userRegisterDTO.setMobileNo("15669059986");
        userRegisterDTO.setBizType("1");
        userRegisterDTO.setEnterName("");
        userRegisterDTO.setIsAssureCom("1");
        userRegisterDTO.setWebUrl("http://127.0.0.1:8080/p2p-dep/test/p2pweb.html");
        userRegisterDTO.setS2SUrl("http://127.0.0.1:8080/p2p-dep/test/p2pweb.html");
        userRegisterDTO.setIdentNo(idCard);
        String reqStr = JSONObject.toJSONString(userRegisterDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "user.register", reqStr);
        return ResultGenerator.genSuccessResult(result);
    }
}
