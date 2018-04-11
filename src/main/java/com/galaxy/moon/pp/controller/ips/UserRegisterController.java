package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.ips.DepositHandler;
import com.galaxy.moon.pp.biz.ips.UserRegisterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create by zhangjun1 on 2018/1/14
 * 负责用户开户的controller
 */
@Controller
@RequestMapping("/xhr/ips/userRegister")
public class UserRegisterController {

    @Autowired
    UserRegisterHandler userRegisterHandler;

    @Autowired
    DepositHandler depositHandler;

    @ResponseBody
    @RequestMapping("/sign")
    public Result userRegister(@RequestBody JSONObject jsonObject, HttpSession httpSession) {
        return userRegisterHandler.userRegister(jsonObject, httpSession);
    }

    @RequestMapping("/inform")
    public void inform(@RequestParam("resultCode") String resultCode,
                             @RequestParam("resultMsg") String resultMsg,
                             @RequestParam("merchantID") String merchantID,
                             @RequestParam("sign") String sign,
                             @RequestParam("response") String response, HttpServletResponse httpResponse,  HttpSession httpSession) {
        userRegisterHandler.inform(resultCode, resultMsg, merchantID, sign, response, httpResponse, httpSession);
    }
}
