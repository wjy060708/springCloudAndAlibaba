package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:11
 */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker //开启服务降级
public class OrderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixApplication.class, args);
    }
}
