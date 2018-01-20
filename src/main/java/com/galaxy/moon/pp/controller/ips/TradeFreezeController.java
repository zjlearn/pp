package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSON;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.IpsResponse;
import com.galaxy.moon.pp.model.IpsRequestParam;
import com.galaxy.moon.pp.model.dto.FreezeDTO;
import com.galaxy.moon.pp.util.IPSHttpUtil;
import com.galaxy.moon.pp.util.IPSOperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        IpsResponse result = ipsHttpUtil.post(IpsRequestParam.merchantID, IPSOperationTypeEnum.TRADE_FREEZE.getName(),
                JSON.toJSONString(freezeDTO));
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/s2s")
    public String notice(@RequestParam("resultCode") String resultCode,
                         @RequestParam("resultMsg") String resultMsg,
                         @RequestParam("merchantID") String merchantID,
                         @RequestParam("sign") String sign,
                         @RequestParam("response") String response) {

        return IpsRequestParam.scuessCode;
    }
}
