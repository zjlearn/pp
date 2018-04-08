package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.dto.AutoSignDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * create by zhangjun1 on 2018/4/2
 */
@Component
public class AutoSignHandler {

    @Autowired
    BillIdService billIdService;

    public Result sign(JSONObject jsonObject, HttpSession httpSession) {
        String billNo = billIdService.nextStrId();

        Double amount = jsonObject.getDouble("amount");
        User user = (User) httpSession.getAttribute("user");

        AutoSignDTO autoSignDTO = new AutoSignDTO();
        String reqStr = JSONObject.toJSONString(autoSignDTO);

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
