package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.dto.CloseAccountDTO;
import com.galaxy.moon.pp.model.dto.UserRegisterDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@Component
public class CloseAccountHandler {

    @Autowired
    BillIdService billIdService;

    @Autowired
    UserService userService;

    /**
     * @param jsonObject
     * @param httpSession
     * @return
     */
    public Result sign(JSONObject jsonObject, HttpSession httpSession) {
        try {
            User user = (User) httpSession.getAttribute("user");
            long userId = user.getId();
            if (null == user.getIpsAccount()) {
                user = userService.findById(userId);
            }

            CloseAccountDTO closeAccountDTO = new CloseAccountDTO();
            closeAccountDTO.setUserName(user.getUserName());
            closeAccountDTO.setIpsAcctNo(user.getIpsAccount());
            closeAccountDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/closeAccount/inform");
            closeAccountDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/closeAccount");
            String reqStr = JSONObject.toJSONString(closeAccountDTO);

            JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "user.register", reqStr);
            return ResultGenerator.genSuccessResult(result);
        } catch (Exception e) {
            return ResultGenerator.genFailResult();
        }
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
