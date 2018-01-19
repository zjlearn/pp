package com.galaxy.moon.pp.controller;


import com.galaxy.moon.pp.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * create by zhangjun1 on 2018/1/12
 * 产品相关的
 */
@RestController
public class ProductController {
    @RequestMapping("/list")
    public List<Product> listProducts(){
        return new ArrayList<>();
    }
}
