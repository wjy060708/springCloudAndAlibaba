package com.wangjinyin.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;
import com.wangjinyin.springcloud.service.PaymentFeignHystrixService;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:14
 */
@RestController
public class OrderFeignHystrixController {

	@Autowired
	private PaymentFeignHystrixService paymentFeignHystrixService;

	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		return paymentFeignHystrixService.paymentInfo_OK(id);
	}

	// 业务失败会调用paymentInfo_timeout_handller方法处理
	// execution.isolation.thread.timeoutInMilliseconds处理超过没三秒
	@HystrixCommand(fallbackMethod = "paymentInfo_timeout_handller", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000") })
	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		return paymentFeignHystrixService.paymentInfo_TimeOut(id);
	}

	// 超时处理方法
	public String paymentInfo_timeout_handller(Integer id) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "线程池" + Thread.currentThread().getName() + "paymentInfo_timeout_handller 客户端 80   超时";
	}
}
