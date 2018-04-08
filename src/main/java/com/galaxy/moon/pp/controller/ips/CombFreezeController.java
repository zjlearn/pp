package com.galaxy.moon.pp.controller.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.ips.CombFreezeHandler;
import com.galaxy.moon.pp.biz.ips.FreezeHandler;
import com.galaxy.moon.pp.model.IpsRequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create by zhangjun1 on 2018/1/20
 * 红包组合冻结接口
 */
@Controller
@RequestMapping("/xhr/ips/combFree")
public class CombFreezeController {
    @Autowired
    CombFreezeHandler  combFreezeHandler;

    @ResponseBody
    @RequestMapping("/sign")
    public Result sign(@RequestBody JSONObject jsonObject, HttpSession httpSession) {
        return combFreezeHandler.sign(jsonObject, httpSession);
    }

    @RequestMapping("/inform")
    public void inform(@RequestParam("resultCode") String resultCode,
                       @RequestParam("resultMsg") String resultMsg,
                       @RequestParam("merchantID") String merchantID,
                       @RequestParam("sign") String sign,
                       @RequestParam("response") String response, HttpServletResponse httpResponse) {
        combFreezeHandler.inform(resultCode, resultMsg, merchantID, sign, response, httpResponse);
    }
}
