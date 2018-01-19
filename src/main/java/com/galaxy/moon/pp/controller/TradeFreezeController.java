package com.galaxy.moon.pp.controller;

import com.alibaba.fastjson.JSON;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.IpsResponse;
import com.galaxy.moon.pp.model.ModelParam;
import com.galaxy.moon.pp.model.dto.FreezeDTO;
import com.galaxy.moon.pp.util.IPSHttpUtil;
import com.galaxy.moon.pp.util.IPSOperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by zhangjun1 on 2018/1/14
 */
@RestController
@RequestMapping("/xhr")
public class TradeFreezeController {
    @Autowired
    IPSHttpUtil ipsHttpUtil;

    @RequestMapping("/tradeFreeze")
    public Result tradeFreeze(@RequestBody FreezeDTO freezeDTO) {
        IpsResponse result = ipsHttpUtil.post(ModelParam.merchantID, IPSOperationTypeEnum.TRADE_FREEZE.getName(),
                JSON.toJSONString(freezeDTO));
        return ResultGenerator.genSuccessResult();
    }
}
