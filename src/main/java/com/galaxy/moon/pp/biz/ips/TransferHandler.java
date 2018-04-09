package com.galaxy.moon.pp.biz.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.common.ResultGenerator;
import com.galaxy.moon.common.util.DateUtil;
import com.galaxy.moon.pp.model.dto.TransferDTO;
import org.springframework.stereotype.Component;

@Component
public class TransferHandler {

    public Result transfer(){

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setMerDate(DateUtil.parseLongToString(System.currentTimeMillis(), DateUtil.defaultDatePattern));
//        transferDTO.setProjectNo();
        return ResultGenerator.genSuccessResult();
    }
}
