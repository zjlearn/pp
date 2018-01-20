package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * create by zhangjun1 on 2018/1/20
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void userAdd(){
        User u = new User();
        u.setAge(11);
        userService.addUser(u);
    }
}
