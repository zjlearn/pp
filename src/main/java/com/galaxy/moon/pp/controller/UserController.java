package com.galaxy.moon.pp.controller;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.biz.UserHandler;
import com.galaxy.moon.pp.model.User;
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
    UserHandler userHandler;

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
                           @RequestParam("password") String password, @RequestParam(value = "inviteCode", required = false) String inviteCode, HttpSession session) {
        return userHandler.register(mobile, password, inviteCode, session);
    }


    // form 的post表单方式提交
    @PostMapping("/login")
    public Result login(@RequestParam("mobile") String mobile, @RequestParam("password") String password, HttpSession httpSession) {
        return userHandler.login(mobile, password, httpSession);
    }

    // form 的post表单方式提交
    @GetMapping("/currentUser")
    public Result login(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        return ResultGenerator.genSuccessResult(user);
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
