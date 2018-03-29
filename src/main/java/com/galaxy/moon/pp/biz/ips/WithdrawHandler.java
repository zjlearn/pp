package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
<<<<<<< HEAD
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.dto.WithDrawDTO;
import com.galaxy.moon.pp.service.UUIDService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * create by zhangjun1 on 2018/3/27
 * 提现处理类
 */
@Component
public class WithdrawHandler {
    @Autowired
    UUIDService uuidService;

    @Autowired
    UserService userService;

    public Result deposit(JSONObject jsonObject) {
        String billNo = uuidService.nextStrId();
        long userId = jsonObject.getLong("userId");
        User user = userService.findById(userId);

        WithDrawDTO withDrawDTO = new WithDrawDTO();
        withDrawDTO.setMerBillNo(billNo);
        withDrawDTO.setMerFee("1");

        String reqStr = JSONObject.toJSONString(withDrawDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "trade.deposit", reqStr);
        return ResultGenerator.genSuccessResult(result);
    }
}
