package com.galaxy.moon.pp.biz.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import org.springframework.stereotype.Component;

@Component
public class ModifyProjectHandler {

    public Result modify(){

        return ResultGenerator.genSuccessResult();
    }
}
