package com.wangjinyin.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;
import com.wangjinyin.springcloudalibaba.service.PaymentFeignService;

@RestController
public class CicleBreakerController {

	@Value("${service-url.nacos-user-service}")
	private String serverUrl;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PaymentFeignService paymentFeignService;

	@GetMapping(value = "/consumer/fallback/{id}")
	//@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")
	@SentinelResource(value = "fallback", blockHandler = "blockHanlder", fallback = "handlerFallback")
	public CommonResult<Payment> fallBack(@PathVariable("id") long id) {
		
		CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/payment/nacos/" + id, CommonResult.class,id);
	   
	    if (id == 4) {
	    	throw new IllegalArgumentException("非法参数异常");
		} else if(result.getData() == null){
			throw new NullPointerException("空指针异常");
		}
		return result;
	}
	
	public CommonResult<Payment> handlerFallback(@PathVariable("id") long id,  Throwable e) {
		Payment payment = new Payment(id, null);
		return new CommonResult<Payment>(444, "出现运行时异常" + e.getMessage(), payment);
	}
	
	public CommonResult<Payment> blockHanlder(@PathVariable("id") long id,  Throwable e) {
		Payment payment = new Payment(id, null);
		return new CommonResult<Payment>(445, "配置降级" + e.getMessage(), payment);
	}
	
	
	@GetMapping(value = "/consumer/paymentSql/{id}")
	//@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")
	@SentinelResource(value = "fallback", blockHandler = "blockHanlder", fallback = "handlerFallback")
	public CommonResult<Payment> paymentSql(@PathVariable("id") long id) {
		
		return paymentFeignService.getPaymentById(id);
	}
}
