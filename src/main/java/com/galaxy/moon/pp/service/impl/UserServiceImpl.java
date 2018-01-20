package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.UserMapper;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.UserTemp;
import com.galaxy.moon.pp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by zhangjun1 on 2018/1/20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(String name) {
        return userMapper.selectByPrimaryKey(1L);
    }

    @Override
    public int addUser(User u) {
        return userMapper.insert(u);
    }
}
