package com.galaxy.moon.pp.biz.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.dto.ModifyProjectDTO;
import org.springframework.stereotype.Component;

@Component
public class ModifyProjectHandler {

    public Result modify(){
        ModifyProjectDTO modifyProjectDTO = new ModifyProjectDTO();

        return ResultGenerator.genSuccessResult();
    }
}
