package com.galaxy.moon.pp.dao;

import com.galaxy.moon.pp.model.bean.RegUserBill;

public interface RegUserBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RegUserBill record);

    int insertSelective(RegUserBill record);

    RegUserBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RegUserBill record);

    int updateByPrimaryKey(RegUserBill record);

    RegUserBill selectByBillNo(String  billNO);
}