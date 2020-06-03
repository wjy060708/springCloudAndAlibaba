package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //开启eureka服务
public class EurekaMain7001 {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7001.class, args);
	}
}
