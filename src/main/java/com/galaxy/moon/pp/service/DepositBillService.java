package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.bean.DepositBill;

/**
 * create by zhangjun1 on 2018/4/3
 */
public interface DepositBillService {

    int deleteByPrimaryKey(Long id);

    int insert(DepositBill record);

    int insertSelective(DepositBill record);

    DepositBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DepositBill record);

    int updateByPrimaryKey(DepositBill record);

    DepositBill selectByBillNo(String billNo);
}
