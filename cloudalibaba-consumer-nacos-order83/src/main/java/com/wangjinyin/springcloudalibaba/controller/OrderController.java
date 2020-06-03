package com.wangjinyin.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	@Value("${service-url.nacos-user-service}")
	private String serverUrl;
	
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    
    @Autowired
    private RestTemplate restTemplate;

	@GetMapping(value = "/consumer/payment/nacos/{id}")
	public String getPayment(@PathVariable("id") String id) {
		return restTemplate.getForObject(serverUrl+"/payment/nacos/" + id, String.class);
	}
}
