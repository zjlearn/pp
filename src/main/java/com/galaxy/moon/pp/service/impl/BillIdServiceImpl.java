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
        long id = 0L;
        while (id < 1000) {
            id = new Random().nextLong();
        }
        return String.valueOf(id);
    }

    @Override
    public Long nextLongId() {
        return new Random().nextLong();
    }
}
