package com.galaxy.moon.pp.controller;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.biz.UserHandler;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.vo.UserRegisterVO;
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
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterVO userRegisterVO, HttpSession session) {
        return userHandler.register(userRegisterVO, session);
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
        System.out.println("获取当前用户："+ user);
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
