package com.galaxy.moon.pp.biz.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.dto.UnFreezeDTO;
import org.springframework.stereotype.Component;

/**
 * 解冻解耦
 */
@Component
public class UnFreezeHandler {
    public Result unFreeze(){
        UnFreezeDTO unFreezeDTO = new UnFreezeDTO();
        unFreezeDTO.setWebUrl(IPSCONSTANTS.server_Domain + "");
        return ResultGenerator.genSuccessResult();
    }
}
