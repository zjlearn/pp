package com.galaxy.moon.pp.service.impl;

import com.galaxy.moon.pp.dao.LoanBillMapper;
import com.galaxy.moon.pp.model.bean.LoanBill;
import com.galaxy.moon.pp.service.LoanBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanBillServiceImpl implements LoanBillService {

    @Autowired
    LoanBillMapper loanBillMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        return loanBillMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LoanBill record) {
        return loanBillMapper.insert(record);
    }

    @Override
    public int insertSelective(LoanBill record) {
        return loanBillMapper.insertSelective(record);
    }

    @Override
    public LoanBill selectByPrimaryKey(Long id) {
        return loanBillMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LoanBill record) {
        return loanBillMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LoanBill record) {
        return loanBillMapper.updateByPrimaryKey(record);
    }
}
