package com.wangjinyin.springcloudalibaba.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;

@RestController
public class PaymentController {
	
	@Value("${server.port}")
	private String serverPort;
	
	public static HashMap<Long, Payment> hashMap = new HashMap<Long, Payment>();
	
	static {
		hashMap.put(1l, new Payment(1l, "123456789"));
		hashMap.put(2l, new Payment(2l, "157585878"));
		hashMap.put(3l, new Payment(3l, "785354635"));
	}

	@GetMapping(value = "/payment/nacos/{id}")
	public CommonResult getPayment(@PathVariable("id") long id) {
	   Payment payment = hashMap.get(id);
	   CommonResult<Payment> commonResult = new CommonResult<Payment>(200, "from mysql" + serverPort,payment);
	   return commonResult;
	}
}
