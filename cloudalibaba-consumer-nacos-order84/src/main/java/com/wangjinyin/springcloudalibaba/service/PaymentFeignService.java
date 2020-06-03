 package com.wangjinyin.springcloudalibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wangjinyin.springcloud.entites.CommonResult;

@Configuration
@FeignClient(value = "nacos-payment-provider" ,fallback = PaymentFallbackServiceImpl.class)
public interface PaymentFeignService {
	
	   @GetMapping(value = "payment/nacos/{id}")
	   public CommonResult getPaymentById(@PathVariable("id") Long id);
	  
}
