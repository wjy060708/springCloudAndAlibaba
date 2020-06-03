package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jinyin wang
 * @create 2020-04-09 11:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderPaymentApplication8004 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentApplication8004.class,args);
    }
}
