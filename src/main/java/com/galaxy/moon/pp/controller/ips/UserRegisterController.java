package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.ips.DepositHandler;
import com.galaxy.moon.pp.biz.ips.UserRegisterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by zhangjun1 on 2018/1/14
 * 负责用户开户的controller
 */
@RestController
@RequestMapping("/xhr/ips")
public class UserRegisterController {

    @Autowired
    UserRegisterHandler userRegisterHandler;

    @Autowired
    DepositHandler depositHandler;

    @RequestMapping("/userRegister")
    public Result userRegister(@RequestBody JSONObject jsonObject) {
        return userRegisterHandler.userRegister(jsonObject);
    }

    @RequestMapping("/deposit")
    public Result deposit(@RequestBody JSONObject jsonObject) {
        return depositHandler.deposit(jsonObject);
    }
}
