package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.bean.OpenAccountBill;

public interface OpenAccountService {
    int insert(OpenAccountBill record);

    int insertSelective(OpenAccountBill record);

    OpenAccountBill selectByPrimaryKey(Long id);

    OpenAccountBill selectByBillNo(String billNo);
}
