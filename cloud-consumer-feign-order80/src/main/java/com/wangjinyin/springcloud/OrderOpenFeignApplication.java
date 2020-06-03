package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:11
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignApplication.class, args);
    }
}
