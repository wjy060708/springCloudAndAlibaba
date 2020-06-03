package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //@业务类Controller修改
public class ConfigClientController {
	
	@Value("${server1.port}")
	private String configInfo;
	
	@GetMapping("/configInfo")
	public String getConfigInfo() {
		return configInfo ;
	}
}
