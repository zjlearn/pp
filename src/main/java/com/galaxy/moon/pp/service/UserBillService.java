package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.bean.RegUserBill;

public interface UserBillService {
    RegUserBill selectByBillNo(String  billNO);

    int updateByPrimaryKey(RegUserBill record);

    int insert(RegUserBill record);
}
