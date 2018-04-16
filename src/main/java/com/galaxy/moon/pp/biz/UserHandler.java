package com.galaxy.moon.pp.biz;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.vo.UserRegisterVO;
import com.galaxy.moon.pp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * 用户相关的业务处理类
 */
@Component
public class UserHandler {
    @Autowired
    UserService userService;

    public Result register(UserRegisterVO userRegisterVO, HttpSession session) {
        System.out.println("注册新用户：" + userRegisterVO);
        User user = new User();
        user.setMobile(userRegisterVO.getMobileNo());
        user.setPassword(userRegisterVO.getPassword());
        user.setUserRole(userRegisterVO.getUserRole());
        user.setUserType(userRegisterVO.getUserType());
        int rtn = userService.addUser(user);
        if (rtn == 1) {
            user = userService.findByMobile(userRegisterVO.getMobileNo());  //相当于获取用户的ID
            session.setAttribute("user", user);
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("用户注册失败，请稍后再试！");
        }
    }

    public Result login(String mobile, String password, HttpSession session) {
        User user = userService.findByMobile(mobile);
        if (user != null) {
            session.setAttribute("user", user);
            System.out.println("用户登录: " + user);
            return ResultGenerator.genSuccessResult(user);
        } else {
            return ResultGenerator.genFailResult("用户登录失败，请检查用户名和密码！");
        }
    }

}