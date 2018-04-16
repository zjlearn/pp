package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.*;
import com.galaxy.moon.pp.model.bean.DepositBill;
import com.galaxy.moon.pp.model.bean.User;
import com.galaxy.moon.pp.model.dto.DepositDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.DepositBillService;
import com.galaxy.moon.pp.service.UserService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

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

    @Autowired
    DepositBillService depositBillService;

    /**
     * 参数中需要知道用户ID和 充值金额
     *
     * @param jsonObject
     * @return
     */
    public Result sign(JSONObject jsonObject, HttpSession httpSession) {
        String billNo = billIdService.nextStrId();

        Double amount = jsonObject.getDouble("amount");

        User user = (User) httpSession.getAttribute("user");
        if (user.getIpsAccount() == null) {
            user = userService.findById(user.getId());
        }
        long now = System.currentTimeMillis();
        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setMerBillNo(billNo);
        depositDTO.setMerDate(DateUtil.parseLongToString(now, DateUtil.defaultDatePattern));
        depositDTO.setDepositType(DepositTypeEnum.ORIGIN.type);
        depositDTO.setChannelType(ChannelTypeEnum.PERSON_ONLINE_BANK.type);
        depositDTO.setUserType(String.valueOf(user.getUserType()));
        depositDTO.setIpsAcctNo(user.getIpsAccount());
        depositDTO.setIpsFeeType(IPSFeeTypeEnum.Merchant.type);
        depositDTO.setBankCode("1100");
        depositDTO.setTrdAmt(amount);
        depositDTO.setMerFee(0.0);
        depositDTO.setMerFeeType(MerFeeTypeEnum.OUTER_PAY.type);
        depositDTO.setTaker("2");
        depositDTO.setWebUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/deposit/inform");
        depositDTO.setS2SUrl(IPSCONSTANTS.server_Domain + "/xhr/ips/s2s/deposit");

        String reqStr = JSONObject.toJSONString(depositDTO);
        System.out.println(reqStr);
        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "trade.deposit", reqStr);
        // 生成充值单据
        DepositBill depositBill = new DepositBill();
        depositBill.setDepositType(Byte.valueOf(depositDTO.getDepositType()));
        depositBill.setChannelType(Byte.valueOf(depositDTO.getChannelType()));
        depositBill.setAmount(new BigDecimal(amount));
        depositBill.setBillNo(billNo);
        depositBill.setCreateTime(now);
        depositBill.setUserId(user.getId());
        depositBill.setBankCode("1100");
        depositBill.setBankName("工商银行");
        depositBill.setStatus((byte) TradeStatusEnum.INIT.getStatus());

        int insertResult = depositBillService.insert(depositBill);
        if (1 == insertResult) {
            return ResultGenerator.genSuccessResult(result);
        } else {
            return ResultGenerator.genFailResult("平台系统内部异常，请稍后再试");
        }
    }

    public void inform(String resultCode, String resultMsg, String merchantID, String sign, String response, HttpServletResponse httpServletResponse) {
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String ipsAcctNo = jsonObject.getString("ipsAcctNo");
            String status = jsonObject.getString("trdStatus");
            System.out.println("接收到ips的同步返回, 解析之后得到: " + jsonObject);
            //更新充值单据的信息
            DepositBill depositBill = depositBillService.selectByBillNo(merBillNo);
            depositBill.setStatus(Byte.valueOf(status));
            depositBill.setIpsBillNo(ipsBillNo);
            depositBill.setIpsDoTime(ipsDoTime);
            depositBill.setIpsTrdAmt(BigDecimal.valueOf(jsonObject.getDouble("ipsTrdAmt")));
            depositBill.setIpsFee(BigDecimal.valueOf(jsonObject.getDoubleValue("ipsFee")));
            depositBill.setUpdateTime(System.currentTimeMillis());
            int rtn = depositBillService.updateByPrimaryKey(depositBill);
            System.out.println("deposit handler update result"+ rtn);
            httpServletResponse.sendRedirect(IPSCONSTANTS.server_Domain + "/#/account");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}






















