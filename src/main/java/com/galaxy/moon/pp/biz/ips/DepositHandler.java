package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.*;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.dto.DepositDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * create by zhangjun1 on 2018/3/26
 * 负责充值的component
 */
@Component
public class DepositHandler {

    @Autowired
    BillIdService billIdService;

    @Autowired
    UserService userService;

    /**
     * 参数中需要知道用户ID和 充值金额
     * @param jsonObject
     * @return
     */
    public Result sign(JSONObject jsonObject, HttpSession httpSession) {
        String billNo = billIdService.nextStrId();

        Double amount = jsonObject.getDouble("amount");

        User user = (User) httpSession.getAttribute("user");
        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setMerBillNo(billNo);
        depositDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
        depositDTO.setDepositType(DepositTypeEnum.ORIGIN.type);
        depositDTO.setChannelType(ChannelTypeEnum.PERSON_ONLINE_BANK.type);
        depositDTO.setUserType(String.valueOf(user.getUserType()));
        depositDTO.setIpsAcctNo(user.getIpsAccount());
        depositDTO.setIpsFeeType(IPSFeeTypeEnum.Merchant.type);
        depositDTO.setMerFee(amount);
        depositDTO.setMerFeeType(MerFeeTypeEnum.OUTER_PAY.type);

        depositDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/deposit/inform");
        depositDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/deposit" );

        String reqStr = JSONObject.toJSONString(depositDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "trade.deposit", reqStr);
        return ResultGenerator.genSuccessResult(result);
    }

    public void inform(String resultCode, String resultMsg, String merchantID, String sign, String response, HttpServletResponse httpServletResponse) {
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String ipsAcctNo = jsonObject.getString("ipsAcctNo");
            String status = jsonObject.getString("status");
            System.out.println("接收到ips的同步返回, 解析之后得到: " + jsonObject);
            httpServletResponse.sendRedirect(IPSCONSTANTS.server_Domain + "/#/account");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}






















