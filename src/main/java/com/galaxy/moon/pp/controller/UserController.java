package com.galaxy.moon.pp.controller;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.vo.RegisterUserVO;
import com.galaxy.moon.pp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/register")
    public Result register(@RequestBody RegisterUserVO registerUserVO) {
        System.out.println(registerUserVO);
        User u= registerUserVO.toUser();
        userService.addUser(u);
        return ResultGenerator.genSuccessResult();
    }


    // form 表单方式提交
    @RequestMapping("/login")
    public Result login(@RequestParam("uid") String uid, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(uid, password);
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
        }
        //6、退出
        subject.logout();
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/salt")
    public Result salt(){
        long  salt=0L;
        try {
            SecureRandom  secureRandom = SecureRandom.getInstance("md5");
            salt = secureRandom.nextLong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ResultGenerator.genSuccessResult(salt);
    }
}
