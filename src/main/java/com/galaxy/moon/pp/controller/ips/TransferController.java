package com.galaxy.moon.pp.controller.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by zhangjun1 on 2018/4/2
 * 转账接口
 */
@RestController
public class TransferController {
    public Result transfer() {
        return ResultGenerator.genSuccessResult();
    }
}
