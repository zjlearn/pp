package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.service.UUIDService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * create by zhangjun1 on 2018/3/26
 */
@Service
public class UUIDServiceImpl implements UUIDService {

    @Override
    public String nextStrId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Long nextLongId() {
        return null;
    }
}
