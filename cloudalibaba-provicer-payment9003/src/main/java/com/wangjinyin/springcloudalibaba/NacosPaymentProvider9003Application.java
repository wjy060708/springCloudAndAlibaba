package com.wangjinyin.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProvider9003Application {
	
   public static void main(String[] args) {
	SpringApplication.run(NacosPaymentProvider9003Application.class, args);
   }
}
