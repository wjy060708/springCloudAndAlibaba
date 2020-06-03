package com.wangjinyin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SentinelMainApplication.class, args);
	}
}
