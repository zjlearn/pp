package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.WithdrawBillMapper;
import com.galaxy.moon.pp.model.WithdrawBill;
import com.galaxy.moon.pp.service.WithdrawBillService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by zhangjun1 on 2018/4/3
 */
public class WithdrawBillServiceImpl implements WithdrawBillService {

    @Autowired
    WithdrawBillMapper withdrawBillMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return withdrawBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(WithdrawBill record) {
        return withdrawBillMapper.insert(record);
    }

    @Override
    public int insertSelective(WithdrawBill record) {
        return withdrawBillMapper.insertSelective(record);
    }

    @Override
    public WithdrawBill selectByPrimaryKey(Long id) {
        return withdrawBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(WithdrawBill record) {
        return withdrawBillMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(WithdrawBill record) {
        return withdrawBillMapper.updateByPrimaryKey(record);
    }

    @Override
    public WithdrawBill selectByBillNo(String billNo) {
        return withdrawBillMapper.selectByBillNo(billNo);
    }
}
