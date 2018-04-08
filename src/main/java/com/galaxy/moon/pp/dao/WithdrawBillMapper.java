package com.galaxy.moon.pp.dao;

import com.galaxy.moon.pp.model.bean.WithdrawBill;

public interface WithdrawBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WithdrawBill record);

    int insertSelective(WithdrawBill record);

    WithdrawBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WithdrawBill record);

    int updateByPrimaryKey(WithdrawBill record);

    WithdrawBill selectByBillNo(String billNo);
}