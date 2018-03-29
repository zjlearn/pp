package com.galaxy.moon.pp.controller;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.vo.RegisterUserVO;
import com.galaxy.moon.pp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by zjlearn on 2017/9/30.
 * 处理登录注册的逻辑
 */
@RestController
@RequestMapping("/xhr/user")
public class UserController {

    @Autowired
    UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户注册
     *
     * @param mobile
     * @param password
     * @param inviteCode 邀请码 暂时未使用
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestParam("mobile") String mobile,
                           @RequestParam("password") String password, @RequestParam(value = "inviteCode", required = false) String inviteCode) {
        User user = new User();
        user.setMobile(mobile);
        user.setPassword(password);
        user.setCreateTime(System.currentTimeMillis());
        userService.addUser(user);
        return ResultGenerator.genSuccessResult();
    }


    // form 的post表单方式提交
    @PostMapping("/login")
    public Result login(@RequestParam("mobile") String mobile, @RequestParam("password") String password, HttpSession httpSession) {
        httpSession.setAttribute("mobile", mobile);
        httpSession.setAttribute("password", password);
        httpSession.setAttribute("userName", "曼曼");
        httpSession.setAttribute("userId", 222L);
        System.out.println("用户登录");
        return ResultGenerator.genSuccessResult();
    }

    // form 的post表单方式提交
    @GetMapping("/getUserName")
    public Result login(HttpSession httpSession) {
        Object name = httpSession.getAttribute("userName");
        return ResultGenerator.genSuccessResult(name);
    }

    @RequestMapping("/salt")
    public Result salt() {
        long salt = 0L;
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("md5");
            salt = secureRandom.nextLong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult(salt);
    }
}
