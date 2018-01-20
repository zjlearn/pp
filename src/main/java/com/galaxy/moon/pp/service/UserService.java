package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.UserTemp;

/**
 * create by zhangjun1 on 2018/1/20
 */
public interface UserService {
    User findById(String name);
    int addUser(User u);
}
