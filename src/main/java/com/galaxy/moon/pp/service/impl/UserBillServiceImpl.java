package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.RegUserBillMapper;
import com.galaxy.moon.pp.model.bean.RegUserBill;
import com.galaxy.moon.pp.service.UserBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBillServiceImpl implements UserBillService{
    @Autowired
    RegUserBillMapper regUserBillMapper;

    public RegUserBill selectByBillNo(String  billNO){
        return regUserBillMapper.selectByBillNo(billNO);
    }

    public int updateByPrimaryKey(RegUserBill record){
        return regUserBillMapper.updateByPrimaryKey(record);
    }

    public int insert(RegUserBill record){
        return regUserBillMapper.insert(record);
    }
}
