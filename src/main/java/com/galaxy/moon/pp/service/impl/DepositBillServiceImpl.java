package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.DepositBillMapper;
import com.galaxy.moon.pp.model.bean.DepositBill;
import com.galaxy.moon.pp.service.DepositBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by zhangjun1 on 2018/4/3
 */
@Service
public class DepositBillServiceImpl implements DepositBillService {

    @Autowired
    DepositBillMapper depositBillMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return depositBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DepositBill record) {
        return depositBillMapper.insert(record);
    }

    @Override
    public int insertSelective(DepositBill record) {
        return depositBillMapper.insertSelective(record);
    }

    @Override
    public DepositBill selectByPrimaryKey(Long id) {
        return depositBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DepositBill record) {
        return depositBillMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DepositBill record) {
        return depositBillMapper.updateByPrimaryKey(record);
    }

    @Override
    public DepositBill selectByBillNo(String billNo) {
        return null;
    }


}
