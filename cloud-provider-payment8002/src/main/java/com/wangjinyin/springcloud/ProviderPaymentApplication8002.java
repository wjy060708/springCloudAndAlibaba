package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jinyin wang
 * @create 2020-04-09 11:52
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderPaymentApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentApplication8002.class,args);
    }
}
