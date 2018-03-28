package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import org.springframework.stereotype.Component;

@Component
public class WithdrawHandler {

    public Result withdraw(JSONObject jsonObject){

        return ResultGenerator.genSuccessResult();
    }
}
