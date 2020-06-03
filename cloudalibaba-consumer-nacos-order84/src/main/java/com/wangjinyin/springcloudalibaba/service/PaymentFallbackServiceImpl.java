package com.wangjinyin.springcloudalibaba.service;

import org.springframework.stereotype.Component;

import com.wangjinyin.springcloud.entites.CommonResult;

@Component
public class PaymentFallbackServiceImpl implements PaymentFeignService{

	@Override
	public CommonResult getPaymentById(Long id) {
		return new CommonResult(444,"服务降级返回");
	}
}
