package com.wangjinyin.springcloud.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloud.entites.Payment;
import com.wangjinyin.springcloud.service.PaymentService;

import net.bytebuddy.asm.Advice.This;

/**
 * @author jinyin wang
 * @create 2020-04-09 22:15
 */
@RestController
public class PaymentController {

	    @Autowired
	    private PaymentService paymentService;
	    
	    @Autowired
	    private DiscoveryClient discoveryClient;
	    
	    @Value("${server.port}")
	    private String serverPort;

	    @PostMapping(value = "payment/create")
	    public CommonResult create(@RequestBody Payment payment) {
	     int result =  paymentService.create(payment);
	        System.out.println("插入结果为" + result);
	        if (result > 0) {
	            return new CommonResult(200,serverPort+":插入成功");
	        } else {
	            return new CommonResult(404,serverPort +":插入失败");
	        }
	    }


	    @GetMapping(value = "payment/get/{id}")
	    public CommonResult getPaymentById(@PathVariable("id") Long id) {
	        Payment payment = paymentService.getPaymentById(id);
	        if (payment != null) {
	            return new CommonResult(200,serverPort+":查询成功",payment);
	        } else {
	            return new CommonResult(404,serverPort+":查询失败", null);
	        }
	    }
	    
	    @GetMapping(value = "/payment/discovry")
	    public Object discovery() {
	    	List<String> service = discoveryClient.getServices();
	    	for (String string : service) {
				System.out.println(string);
			}
	    	
	    	List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
	    	for (ServiceInstance serviceInstance : instances) {
				System.out.println(serviceInstance.getInstanceId()+"\t" + serviceInstance.getHost()+"\t" + serviceInstance.getUri());
			}
	    	
	    	return this.discoveryClient;
	    }
	    
	    @GetMapping(value = "/payment/lb")
	    public String getPaymentLB() {
	        return serverPort;
	    }
	    
	    @GetMapping(value = "/payment/feign/timeout")
	    public String paymentFeignTimeOut() {
	    	try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return serverPort;
	    }
	    
	    @GetMapping("zipkin")
	    public String paymentZipkin() {
	        return "hi,i`am paymentzipkin server fall back.welcome to atguigu.hahahahahhahahah";
	    }
	     

}
