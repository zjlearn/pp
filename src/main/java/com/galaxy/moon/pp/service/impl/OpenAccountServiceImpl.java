package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.OpenAccountBillMapper;
import com.galaxy.moon.pp.model.OpenAccountBill;
import com.galaxy.moon.pp.service.OpenAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenAccountServiceImpl implements OpenAccountService {

    @Autowired
    OpenAccountBillMapper openAccountBillMapper;

    @Override
    public int insert(OpenAccountBill record) {
        return openAccountBillMapper.insert(record);
    }

    @Override
    public int insertSelective(OpenAccountBill record) {
        return openAccountBillMapper.insertSelective(record);
    }

    @Override
    public OpenAccountBill selectByPrimaryKey(Long id) {
        return openAccountBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public OpenAccountBill selectByBillNo(String billNo) {
        return openAccountBillMapper.selectByBillNo(billNo);
    }
}
