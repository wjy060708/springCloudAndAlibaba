package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.lang.UUID;

/**
 * @author jinyin wang
 * @create 2020-04-09 22:15
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "payment/consule")
    public String paymentInfo() {
      return serverPort + UUID.randomUUID().toString();
    }
}
