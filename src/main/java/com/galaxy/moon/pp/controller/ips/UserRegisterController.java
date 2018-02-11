package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.pp.model.IpsRequestParam;
import com.galaxy.moon.pp.model.dto.UserRegisterDTO;
import com.galaxy.moon.pp.util.IPSOperationTypeEnum;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * create by zhangjun1 on 2018/1/14
 * 负责用户开户的controller
 */
@RestController
@RequestMapping("/xhr/userRegister")
public class UserRegisterController {

    @RequestMapping("sign")
    public JSONObject sign(@RequestBody JSONObject jsonObject) {
        String realName = jsonObject.getString("realName");
        String idCard = jsonObject.getString("idCard");

        String Id = UUID.randomUUID().toString();
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setMerBillNo("23235413");
        userRegisterDTO.setMerDate("2018-01-10");
        userRegisterDTO.setUserName("zj");
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
        JSONObject result = IPSRSAUtil.genReqData(IpsRequestParam.merchantID, IPSOperationTypeEnum.USER_REGISTER.getName(), reqStr);
        System.out.println(result);
        return result;
    }

    @RequestMapping("/s2s")
    public String notice(@RequestParam("resultCode") String resultCode,
                         @RequestParam("resultMsg") String resultMsg,
                         @RequestParam("merchantID") String merchantID,
                         @RequestParam("sign") String sign,
                         @RequestParam("response") String response) {
        System.out.println(response);
        return IpsRequestParam.scuessCode;
    }
}
