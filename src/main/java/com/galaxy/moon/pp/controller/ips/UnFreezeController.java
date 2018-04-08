package com.galaxy.moon.pp.controller.ips;

import com.galaxy.moon.common.Result;
import com.galaxy.moon.pp.biz.ips.UnFreezeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xhr/ips/unFreeze")
public class UnFreezeController {

    @Autowired
    UnFreezeHandler unFreezeHandler;

    Result unFreeze(){
        return unFreezeHandler.unFreeze();
    }
}
