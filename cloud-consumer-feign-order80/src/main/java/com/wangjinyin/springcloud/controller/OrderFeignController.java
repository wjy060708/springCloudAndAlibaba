package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;
import com.wangjinyin.springcloud.service.PaymentFeignService;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:14
 */
@RestController
public class OrderFeignController {

	@Autowired
    private PaymentFeignService paymentFeignService;
  
	 @GetMapping(value = "payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		 
		 return paymentFeignService.getPaymentById(id);
	}
	 
	  @GetMapping(value = "/payment/feign/timeout")
	    public String paymentFeignTimeOut() {
		 return paymentFeignService.paymentFeignTimeOut();
	  }
}
