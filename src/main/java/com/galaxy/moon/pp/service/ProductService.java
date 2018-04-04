package com.galaxy.moon.pp.service;

import com.galaxy.moon.pp.model.Product;

public interface ProductService {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}
