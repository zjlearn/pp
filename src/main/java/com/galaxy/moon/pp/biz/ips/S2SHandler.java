package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 负责接收Ip是消息通知的处理类， 该方式是异步回调
 *
 */
@Component
public class S2SHandler {

    private final Logger logger = LoggerFactory.getLogger(S2SHandler.class);


    /**
     * 需要根据订单号查询出用户信息，之后做相应的关联
     * @param resultCode
     * @param resultMsg
     * @param merchantID
     * @param sign
     * @param response
     * @return
     */
    public String userRegister(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        if (resultCode.equals(IPSCONSTANTS.RESPONSE_FAIL_CODE)) {
            logger.error("用户开户失败");
        }
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String ipsAcctNo = jsonObject.getString("ipsAcctNo");
            String status = jsonObject.getString("status");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IPSCONSTANTS.S2S_SCUESSCODE;
    }

    /**
     * 需要根据订单号查询出用户信息，之后做相应的关联
     * @param resultCode
     * @param resultMsg
     * @param merchantID
     * @param sign
     * @param response
     * @return
     */
    public String closeAccount(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        if (resultCode.equals(IPSCONSTANTS.RESPONSE_FAIL_CODE)) {
            logger.error("用户销户失败");
        }
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String userName = jsonObject.getString("userName");  //商户订单
            String ipsAcctNo = jsonObject.getString("ipsAcctNo");
            String merDate = jsonObject.getString("merDate");
            String strType = jsonObject.getString("strType");
            String strMsg = jsonObject.getString("strMsg");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IPSCONSTANTS.S2S_SCUESSCODE;
    }



    /**
     * @param resultCode
     * @param resultMsg
     * @param merchantID
     * @param sign
     * @param response
     * @return
     */
    public String regProject(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        if (resultCode.equals(IPSCONSTANTS.RESPONSE_FAIL_CODE)) {
            logger.error("项目登记失败");
        }
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String projectNo = jsonObject.getString("projectNo");
            String status = jsonObject.getString("status");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IPSCONSTANTS.S2S_SCUESSCODE;
    }


    /**
     * 追加登记接口
     * @param resultCode
     * @param resultMsg
     * @param merchantID
     * @param sign
     * @param response
     * @return
     */
    public String assureProject(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        if (resultCode.equals(IPSCONSTANTS.RESPONSE_FAIL_CODE)) {
            logger.error("项目追加登记失败");
        }
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String projectNo = jsonObject.getString("projectNo");
            String status = jsonObject.getString("status");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IPSCONSTANTS.S2S_SCUESSCODE;
    }



    /**
     * 追加登记接口
     * @param resultCode
     * @param resultMsg
     * @param merchantID
     * @param sign
     * @param response
     * @return
     */
    public String freeze(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        if (resultCode.equals(IPSCONSTANTS.RESPONSE_FAIL_CODE)) {
            logger.error("冻结失败");
        }
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsAcctNo = jsonObject.getString("ipsAcctNo");
            String ipsTrdAmt = jsonObject.getString("ipsTrdAmt");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String projectNo = jsonObject.getString("projectNo");
            String trdStatus = jsonObject.getString("trdStatus");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IPSCONSTANTS.S2S_SCUESSCODE;
    }



    /**
     * 充值接口
     * @param resultCode
     * @param resultMsg
     * @param merchantID
     * @param sign
     * @param response
     * @return
     */
    public String deposit(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        if (resultCode.equals(IPSCONSTANTS.RESPONSE_FAIL_CODE)) {
            logger.error("充值失败");
        }
        try {
            JSONObject jsonObject = IPSRSAUtil.analysisDepRespData(merchantID, resultCode, resultMsg, sign, response);
            String merBillNo = jsonObject.getString("merBillNo");  //商户订单
            String depositType = jsonObject.getString("depositType");  //商户订单
            String channelType = jsonObject.getString("channelType");  //商户订单
            String bankCode = jsonObject.getString("bankCode");  //商户订单
            String ipsBillNo = jsonObject.getString("ipsBillNo");
            String ipsAcctNo = jsonObject.getString("ipsAcctNo");
            String ipsTrdAmt = jsonObject.getString("ipsTrdAmt");
            String ipsDoTime = jsonObject.getString("ipsDoTime");
            String projectNo = jsonObject.getString("projectNo");
            String trdStatus = jsonObject.getString("trdStatus");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return IPSCONSTANTS.S2S_SCUESSCODE;
    }

}
