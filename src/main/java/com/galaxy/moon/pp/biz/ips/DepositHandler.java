package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.dto.DepositDTO;
import com.galaxy.moon.pp.service.UUIDService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * create by zhangjun1 on 2018/3/26
 * 负责充值的component
 */
@Component
public class DepositHandler {

    @Autowired
    UUIDService uuidService;

    @Autowired
    UserService userService;

    /**
     * 参数中需要知道用户ID和 充值金额
     * @param jsonObject
     * @return
     */
    public Result deposit(JSONObject jsonObject) {
        String billNo = uuidService.nextStrId();
        long userId = jsonObject.getLong("userId");
        double amount = jsonObject.getDouble("amount"); //
        User user = userService.findById(userId);

        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setMerBillNo(billNo);
        depositDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
        depositDTO.setDepositType("1");
        depositDTO.setChannelType("1");
        depositDTO.setUserType(String.valueOf(user.getUserType()));
        depositDTO.setIpsAcctNo(user.getIpsAccount());
        depositDTO.setIpsFeeType("1");
        depositDTO.setMerFee(amount);
        depositDTO.setMerFeeType("1");

        String reqStr = JSONObject.toJSONString(depositDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "trade.deposit", reqStr);
        return ResultGenerator.genSuccessResult(result);
    }
}






















