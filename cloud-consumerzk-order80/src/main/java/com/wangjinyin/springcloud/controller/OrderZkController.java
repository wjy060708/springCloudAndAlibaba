package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;


/**
 * @author jinyin wang
 * @create 2020-04-11 13:14
 */
@RestController
public class OrderZkController {

    private static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/cosumer/payment/create")
    public ResponseEntity<String> paymentInfo() {
    	ResponseEntity<String> result = restTemplate.getForEntity(PAYMENT_URL+"/payment/zk", String.class);
		return result;
    }
}
