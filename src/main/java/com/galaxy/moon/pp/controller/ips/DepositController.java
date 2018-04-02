package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.ips.DepositHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/xhr/ips/deposit")
public class DepositController {

    @Autowired
    DepositHandler depositHandler;

    @ResponseBody
    @RequestMapping("/sign")
    public Result sign(@RequestBody JSONObject jsonObject, HttpSession httpSession) {
        return depositHandler.sign(jsonObject, httpSession);
    }

    @RequestMapping("/inform")
    public void inform(@RequestParam("resultCode") String resultCode,
                       @RequestParam("resultMsg") String resultMsg,
                       @RequestParam("merchantID") String merchantID,
                       @RequestParam("sign") String sign,
                       @RequestParam("response") String response, HttpServletResponse httpResponse) {
        depositHandler.inform(resultCode, resultMsg, merchantID, sign, response, httpResponse);
    }
}
