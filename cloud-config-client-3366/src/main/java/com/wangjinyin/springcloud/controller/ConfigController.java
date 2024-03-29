package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

	@Value("${server1.port}")
    private String infoAge;

    @RequestMapping("/getServerPort")
    public String getServerPort() {
        return infoAge;
    }
}
 
 