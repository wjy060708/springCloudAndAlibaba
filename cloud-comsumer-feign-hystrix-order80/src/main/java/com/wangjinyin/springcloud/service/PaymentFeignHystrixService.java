package com.wangjinyin.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentFeignHystrixService {
	
	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id);

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id);

}
