package com.galaxy.moon.pp.biz.ips;

import com.alibaba.fastjson.JSONObject;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.dto.ModifyProjectDTO;
import com.galaxy.moon.pp.service.BillIdService;
import com.galaxy.moon.pp.util.IPSHttpUtil;
import com.galaxy.moon.pp.util.IPSRSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 借口最后写
 */
@Component
public class ModifyProjectHandler {
    @Autowired
    BillIdService billIdService;

    @Autowired
    IPSHttpUtil ipsHttpUtil;

    public Result modify(){
        ModifyProjectDTO modifyProjectDTO = new ModifyProjectDTO();
        String billNo = billIdService.nextStrId();
        modifyProjectDTO.setMerBillNo(billNo);
        modifyProjectDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
        modifyProjectDTO.setModifyType("1");


        String reqStr = JSONObject.toJSONString(modifyProjectDTO);

        JSONObject result = IPSRSAUtil.genReqData(IPSCONSTANTS.merchantID, "project.modifyProject", reqStr);

        // 发送http请求
//        ipsHttpUtil.post(IPSCONSTANTS.merchantID, );

        return ResultGenerator.genSuccessResult();
    }
}
