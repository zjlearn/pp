package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.UserMapper;
import com.galaxy.moon.pp.model.User;
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
    public User findById(long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User findByMobile(String mobile) {
        return userMapper.selectByMobile(mobile);
    }

    @Override
    public int addUser(User u) {
        return userMapper.insert(u);
    }

    @Override
    public int updateByUserId(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
