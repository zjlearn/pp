package com.galaxy.moon.pp.controller.ips;

import com.galaxy.moon.pp.biz.ips.S2SHandler;
import com.galaxy.moon.pp.model.IpsRequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 负责接收ips s2s通知的controller
 * todo 实现各个不同功能的s2s通知
 */

@RestController
@RequestMapping("/ips/s2s")
public class S2SController {

    @Autowired
    S2SHandler s2SHandler;

    @RequestMapping("/userRegister")
    public String userRegister(@RequestParam("resultCode") String resultCode,
                         @RequestParam("resultMsg") String resultMsg,
                         @RequestParam("merchantID") String merchantID,
                         @RequestParam("sign") String sign,
                         @RequestParam("response") String response) {
        return s2SHandler.userRegister(resultCode, resultMsg, merchantID, sign, response);
    }
}
