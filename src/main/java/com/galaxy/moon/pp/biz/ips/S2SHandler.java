package com.galaxy.moon.pp.biz.ips;

import com.galaxy.moon.pp.common.IPSCONSTANTS;
import com.galaxy.moon.pp.model.IpsRequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 负责接收Ip是消息通知的处理类， 该方式是异步回调
 */
@Component
public class S2SHandler {

    private final Logger logger = LoggerFactory.getLogger(S2SHandler.class);

    public String userRegister(String resultCode, String resultMsg, String merchantID, String sign, String response) {
        return IPSCONSTANTS.scuessCode;
    }
}
