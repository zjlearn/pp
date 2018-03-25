package com.galaxy.moon.pp.controller.ips;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 负责接收ips s2s通知的controller
 * todo 实现各个不同功能的s2s通知
 */

@RestController
@RequestMapping("/ips/s2s")
public class S2SController {
    @RequestMapping("/userRegister")
    public void userRegister() {

    }
}
