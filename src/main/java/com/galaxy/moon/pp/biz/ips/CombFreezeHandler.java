package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.dto.CombFreezeDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CombFreezeHandler {

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

        User user = (User) httpSession.getAttribute("user");
        CombFreezeDTO combFreezeDTO = new CombFreezeDTO();

        combFreezeDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/freeze/inform");
        combFreezeDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/freeze");
        String reqStr = JSONObject.toJSONString(combFreezeDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "trade.combFreeze", reqStr);
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
