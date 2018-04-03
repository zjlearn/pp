package com.galaxy.moon.pp.controller.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by zhangjun1 on 2018/1/20
 * 修改项目信息，后台接口
 */
@RestController
public class ModifyProjectController {

    public Result modify(){
        return ResultGenerator.genFailResult();
    }
}
