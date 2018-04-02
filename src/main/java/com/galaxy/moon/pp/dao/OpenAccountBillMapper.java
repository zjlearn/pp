package com.galaxy.moon.pp.dao;

import com.galaxy.moon.pp.model.OpenAccountBill;

public interface OpenAccountBillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OpenAccountBill record);

    int insertSelective(OpenAccountBill record);

    OpenAccountBill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OpenAccountBill record);

    int updateByPrimaryKey(OpenAccountBill record);
}