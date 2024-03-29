package com.wangjinyin.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/payment/nacos/{id}")
	public String getPayment(@PathVariable("id") String id) {
		return "nacos resgistry:" + serverPort + "\t id:" + id;
	}
}
