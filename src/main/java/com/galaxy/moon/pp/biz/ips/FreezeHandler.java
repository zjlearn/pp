package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.dto.FreezeDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * create by zhangjun1 on 2018/4/4
 */
@Component
public class FreezeHandler {

    @Autowired
    BillIdService billIdService;

    @Autowired
    UserService userService;

    public Result sign(JSONObject jsonObject, HttpSession httpSession) {
        String billNo = billIdService.nextStrId();
        User user = (User) httpSession.getAttribute("user");
        FreezeDTO freezeDTO = new FreezeDTO();
        freezeDTO.setMerBillNo(billNo);
        String bizType = "";
        String projectNo = "";
        String regType = "";
        String contractNo = "";
        String trdAmt = "";
        String merFee = "";
        String freezeMerType = "";
        freezeDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
        freezeDTO.setProjectNo(projectNo);

        freezeDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/freeze/inform");
        freezeDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/freeze");
        String reqStr = JSONObject.toJSONString(freezeDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "trade.freeze", reqStr);
        return ResultGenerator.genSuccessResult(result);
    }


    public void inform(String resultCode, String resultMsg, String merchantID, String sign, String
            response, HttpServletResponse httpServletResponse) {
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
}



