package com.galaxy.moon.pp.controller;

import com.alibaba.fastjson.JSON;
import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.IpsResponse;
import com.galaxy.moon.pp.model.IPSRequestParam;
import com.galaxy.moon.pp.model.dto.AssureProjectDTO;
import com.galaxy.moon.pp.util.IPSHttpUtil;
import com.galaxy.moon.pp.util.IPSOperationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * create by zhangjun1 on 2018/1/14
 * 后台查询接口
 */
@RestController
@RequestMapping("/xhr")
public class AssureProjectController {
    @Autowired
    IPSHttpUtil ipsHttpUtil;
    @RequestMapping("/assureProject")
    public Result assureProject(@RequestBody AssureProjectDTO assureProjectDTO){
        IpsResponse result = ipsHttpUtil.post(IPSRequestParam.merchantID, IPSOperationTypeEnum.PROJECT_ASSUREPROJECT.getName(),
                JSON.toJSONString(assureProjectDTO));
        return ResultGenerator.genSuccessResult();
    }
}
