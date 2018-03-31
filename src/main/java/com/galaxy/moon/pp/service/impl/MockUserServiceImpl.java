package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.service.UserService;

/**
 * create by zhangjun1 on 2018/3/31
 */
public class MockUserServiceImpl implements UserService {

    private User user;

    @Override
    public User findById(long userId) {
        return user;
    }

    @Override
    public int addUser(User u) {
        this.user = u;
        return 1;
    }

    @Override
    public int updateByUserId(User user) {
        this.user = user;
        return 1;
    }
}
