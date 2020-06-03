package com.wangjinyin.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosPaymentProvider2Application {
	
   public static void main(String[] args) {
	SpringApplication.run(NacosPaymentProvider2Application.class, args);
   }
}
