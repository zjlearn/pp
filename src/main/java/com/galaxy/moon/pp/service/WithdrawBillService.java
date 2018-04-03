package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.WithdrawBill;

/**
 * create by zhangjun1 on 2018/4/3
 */
public interface WithdrawBillService {

    int deleteByPrimaryKey(Long id);

    int insert(WithdrawBill record);

    int insertSelective(WithdrawBill record);

    WithdrawBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WithdrawBill record);

    int updateByPrimaryKey(WithdrawBill record);

    WithdrawBill selectByBillNo(String billNo);
}
