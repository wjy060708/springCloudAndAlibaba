package com.wangjinyin.springcloud.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;
import com.wangjinyin.springcloud.lb.LoadBalancer;


/**
 * @author jinyin wang
 * @create 2020-04-11 13:14
 */
@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private LoadBalancer loadBalancer;
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    //自己实现的负载均衡
    @GetMapping(value = "/consumer/payment/lb")
    public ResponseEntity<String> getPaymentLB() {
    	
    	List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    	
    	if (instances == null || instances.size() < 0) {
			return null;
		}
    	
    	ServiceInstance serviceInstance = loadBalancer.instances(instances);
    	URI uri = serviceInstance.getUri();
    	return restTemplate.getForEntity(uri + "/consumer/payment/lb" , String.class);
    }

    @GetMapping("/cosumer/payment/create")
    public ResponseEntity<CommonResult> create(Payment payment) {
        return  restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/cosumer/payment/get/{id}")
    public ResponseEntity<CommonResult> getPayment(@PathVariable("id") Long id) {

        return restTemplate.getForEntity(PAYMENT_URL+"/payment/get/" + id, CommonResult.class);
    }
    
    @GetMapping("/cosumer/payment/get1/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id) {

    	ResponseEntity<CommonResult> responseEntity  =restTemplate.getForEntity(PAYMENT_URL+"/payment/get/" + id, CommonResult.class);
    	if (responseEntity.getStatusCode().is2xxSuccessful()) {
    		return responseEntity.getBody();
		} else {
			return new CommonResult<Payment>(444,"操作失败");
		}
    }
    
    @GetMapping("/cosumer/payment/zipkin")
    public String paymentZipKin() {
    	String result = restTemplate.getForObject("http://localhost:8001"+"/zipkin", String.class);
    	return result;
    }
}
