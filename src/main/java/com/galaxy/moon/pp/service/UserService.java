package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.User;

/**
 * create by zhangjun1 on 2018/1/20
 */
public interface UserService {
    User findById(long  userId);

    User findByMobile(String mobile);

    int addUser(User u);

    int updateByUserId(User user);



}
