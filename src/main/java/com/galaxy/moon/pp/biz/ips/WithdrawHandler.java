package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.IPSFeeTypeEnum;
import com.galaxy.moon.pp.model.MerFeeTypeEnum;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.UserTypeEnum;
import com.galaxy.moon.pp.model.dto.WithDrawDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * create by zhangjun1 on 2018/3/27
 * 提现处理类
 */
@Component
public class WithdrawHandler {
    @Autowired
    BillIdService billIdService;

    @Autowired
    UserService userService;

    public Result withdraw(JSONObject jsonObject, HttpSession httpSession) {
        String billNo = billIdService.nextStrId();

        Double amount = jsonObject.getDouble("amount");
        User user = (User) httpSession.getAttribute("user");

        WithDrawDTO withDrawDTO = new WithDrawDTO();
        withDrawDTO.setMerBillNo(billNo);
        withDrawDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
        withDrawDTO.setUserType(UserTypeEnum.PERSON.type);
        withDrawDTO.setMerFeeType(MerFeeTypeEnum.OUTER_PAY.type);
        withDrawDTO.setTrdAmt(amount);
        withDrawDTO.setMerFee(1.0);
        withDrawDTO.setIpsFeeType(IPSFeeTypeEnum.Merchant.type);
        withDrawDTO.setIpsAcctNo(user.getIpsAccount());
        withDrawDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/withdraw/inform");
        withDrawDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/withdraw" );


        String reqStr = JSONObject.toJSONString(withDrawDTO);

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
