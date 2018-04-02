package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.service.BillIdService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * create by zhangjun1 on 2018/3/26
 */
@Service
public class BillIdServiceImpl implements BillIdService {

    @Override
    public String nextStrId() {
        return String.valueOf(new Random().nextLong());
    }

    @Override
    public Long nextLongId() {
        return new Random().nextLong();
    }
}
