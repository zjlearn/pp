package com.galaxy.moon.pp.biz.ips;


import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.RateTypeEnum;
import com.galaxy.moon.pp.model.bean.Project;
import com.galaxy.moon.pp.model.dto.RegProjectDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.service.ProjectService;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class RegProjectHandler {

    @Autowired
    BillIdService billIdService;

    @Autowired
    ProjectService productService;

    /**
     * fixme 完成剩余的事情
     * @param jsonObject
     * @param httpSession
     * @return
     */
    public Result sign(JSONObject jsonObject, HttpSession httpSession) {
        try {
            long  productId= jsonObject.getLong("productId");
            Project project = productService.selectByPrimaryKey(productId);
            String billNo =billIdService.nextStrId();
            RegProjectDTO regProjectDTO = new RegProjectDTO();
            regProjectDTO.setMerBillNo(billNo);
            regProjectDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
            regProjectDTO.setProjectNo(project.getProjectNo());
            regProjectDTO.setProjectName(project.getProjectName());
            regProjectDTO.setProjectType("1");
            regProjectDTO.setProjectAmt(project.getAmount().doubleValue()  );
            regProjectDTO.setRateType(RateTypeEnum.FIXED.type);
            regProjectDTO.setRateVal(project.getRateReturn());
            regProjectDTO.setCycVal(project.getDuration());
            //fixme 修改融资方的信息
            regProjectDTO.setFinaAccType("1");
            regProjectDTO.setFinaCertNo("");
            regProjectDTO.setFinaName("");
            regProjectDTO.setFinaIpsAcctNo("");
            regProjectDTO.setIsExcess("0");
            //fixme 设置自动投标的信息
            regProjectDTO.setAutoTender("");

            String reqStr = JSONObject.toJSONString(regProjectDTO);

            JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "project.regProject", reqStr);
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

