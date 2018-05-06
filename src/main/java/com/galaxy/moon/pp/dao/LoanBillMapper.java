package com.galaxy.moon.pp.dao;

import com.galaxy.moon.pp.model.bean.LoanBill;

public interface LoanBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LoanBill record);

    int insertSelective(LoanBill record);

    LoanBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LoanBill record);

    int updateByPrimaryKey(LoanBill record);
}