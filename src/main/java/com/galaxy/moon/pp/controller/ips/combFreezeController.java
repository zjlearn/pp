package com.galaxy.moon.pp.controller.ips;

import com.galaxy.moon.pp.model.IpsRequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by zhangjun1 on 2018/1/20
 * 红包组合冻结接口
 */
@RestController
@RequestMapping("/combFreeze")
public class combFreezeController {
    @RequestMapping("/s2s")
    public String notice(@RequestParam("resultCode") String resultCode,
                         @RequestParam("resultMsg") String resultMsg,
                         @RequestParam("merchantID") String merchantID,
                         @RequestParam("sign") String sign,
                         @RequestParam("response") String response) {

        return IpsRequestParam.scuessCode;
    }
}
