package com.galaxy.moon.pp.biz.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.model.dto.CommonQueryDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class CommonQueryHandler {
    public Result commonQuery(){
        CommonQueryDTO commonQueryDTO = new CommonQueryDTO();
        return ResultGenerator.genSuccessResult();
    }
}
