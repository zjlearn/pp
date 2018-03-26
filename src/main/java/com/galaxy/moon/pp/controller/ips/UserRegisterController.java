package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.ips.UserRegisterHandler;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.IpsRequestParam;
import com.galaxy.moon.pp.model.dto.UserRegisterDTO;
import com.galaxy.moon.pp.util.IPSCertUtil;
import com.galaxy.moon.pp.util.IPSCryptoUtil;
import com.galaxy.moon.pp.util.IPSOperationTypeEnum;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.UUID;

/**
 * create by zhangjun1 on 2018/1/14
 * 负责用户开户的controller
 */
@RestController
@RequestMapping("/xhr/ips")
public class UserRegisterController {

    @Autowired
    UserRegisterHandler userRegisterHandler;

    @RequestMapping("/userRegister")
    public Result sign(@RequestBody JSONObject jsonObject) {
        return userRegisterHandler.userRegister(jsonObject);
    }
}
