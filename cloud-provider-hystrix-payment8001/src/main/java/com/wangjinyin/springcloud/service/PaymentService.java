package com.wangjinyin.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

@Service
public class PaymentService {

	/**
	 * 正常方法
	 * @param id
	 * @return
	 */
	public String paymentInfo_ok(Integer id) {
		return "线程池" + 	Thread.currentThread().getName() + "paymentInfo_ok";
	}
	
	//业务失败会调用paymentInfo_timeout_handller方法处理 execution.isolation.thread.timeoutInMilliseconds处理超过没三秒
	 @HystrixCommand(fallbackMethod = "paymentInfo_timeout_handller",commandProperties = {
	            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
	  })
	public String paymentInfo_timeout(Integer id) {
		
		//int i = 10 / 0;
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "线程池" + 	Thread.currentThread().getName() + "paymentInfo_ok 超时";
	}
	
	//超时处理方法
	public String paymentInfo_timeout_handller(Integer id) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "线程池" + 	Thread.currentThread().getName() + "paymentInfo_timeout_handller 超时";
	}
	
    public String paymentInfo_exception(Integer id) {
		
		int i = 10 / 0;
		
		return "线程池" + 	Thread.currentThread().getName() + "paymentInfo_ok";
	}
    
    //####################服务熔断##########################################
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id<0) {
            throw new RuntimeException("******id不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();  //相当于
        return Thread.currentThread().getName()+"\t" + "成功调用，流水号是：" + simpleUUID;
    }
    
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
    	  
        return "id不能为负数，请稍后再试............"+id;
    }

   
    
}
