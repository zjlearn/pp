package com.galaxy.moon.pp.dao;

import com.galaxy.moon.pp.model.bean.DepositBill;

public interface DepositBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DepositBill record);

    int insertSelective(DepositBill record);

    DepositBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DepositBill record);

    int updateByPrimaryKey(DepositBill record);

    DepositBill selectByBillNo(String billNo);
}