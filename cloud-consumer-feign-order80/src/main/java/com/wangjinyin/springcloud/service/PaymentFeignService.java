package com.wangjinyin.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wangjinyin.springcloud.entites.CommonResult;

@Configuration
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
	
	   @GetMapping(value = "payment/get/{id}")
	   public CommonResult getPaymentById(@PathVariable("id") Long id);
	   
	   @GetMapping(value = "/payment/feign/timeout")
	   public String paymentFeignTimeOut();
}
