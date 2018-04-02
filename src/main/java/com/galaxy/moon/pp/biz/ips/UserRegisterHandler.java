package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.controller.ips.UserRegisterController;
import com.galaxy.moon.pp.model.User;
import com.galaxy.moon.pp.model.dto.UserRegisterDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

/**
 * 负责ips的用户注册类
 */
@Component
public class UserRegisterHandler {
    @Autowired
    UserService userService;

    @Autowired
    BillIdService billIdService;

    private Logger logger = LoggerFactory.getLogger(UserRegisterController.class);

    public Result userRegister(JSONObject jsonObject, HttpSession httpSession) {
        System.out.println("开始=用户开户");
        String realName = jsonObject.getString("name");
        String idCard = jsonObject.getString("idCard");

        try {
            User user = (User) httpSession.getAttribute("user");
            user.setUserName(realName);
            user.setIdCard(idCard);
            int updateStatus = userService.updateByUserId(user);

            if (0 == updateStatus) {
                logger.error("更新用户信息失败，请稍后再试!");
            }

            String orderId = String.valueOf(new Random().nextLong());
            System.out.println("orderId 是："+ orderId);

            UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
            userRegisterDTO.setMerBillNo(orderId);
            userRegisterDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
            userRegisterDTO.setUserName(realName);
            userRegisterDTO.setUserType("1");
            userRegisterDTO.setUserRole("1");
            userRegisterDTO.setRealName(realName);
            userRegisterDTO.setMobileNo(user.getMobile());
            userRegisterDTO.setBizType("1");
            userRegisterDTO.setEnterName("");
            userRegisterDTO.setIsAssureCom("1");
            userRegisterDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/userRegister/inform");
            userRegisterDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/userRegister");
            userRegisterDTO.setIdentNo(idCard);
            String reqStr = JSONObject.toJSONString(userRegisterDTO);

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
