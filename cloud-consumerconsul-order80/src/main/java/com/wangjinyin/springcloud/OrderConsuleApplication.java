package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsuleApplication.class, args);
    }
}
