package com.wangjinyin.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wangjinyin.springcloud.myhadler.CustomerBlockHadler;

@RestController
public class SentinelController {
	
	
	@GetMapping("/customerBlockHadler")
	@SentinelResource(value =  "customerBlockHadler", 
	blockHandlerClass = CustomerBlockHadler.class, 
	blockHandler = "hadlerException")
	public String  customerBlockHadler() {
	
		return "用户自定义。。。。。。。。。。。。。。。。。。。";
	}
	
	@GetMapping("/byResource")
	@SentinelResource(value =  "byResource", blockHandler = "handleException")
	public String  byResource() {
	
		return "按照资源名称限流";
	}
	
	public String handleException() {
		return "被限流，兜底方法";
	}

	@GetMapping("/test1")
	public String  test1() {
	
		return "test1............";
	}
	
	@GetMapping("/test2")
	public String  test2() {
		return "test2............";
	}
	
	@GetMapping("/test3")
	public String  tes3() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "test3............";
	}
	
	@GetMapping("/test4")
	public String  tes4() {
		int i = 10 / 0;
		return "test4............";
	}
	
	@GetMapping("/testHotKey")
	@SentinelResource(value =  "testHotKey", blockHandler = "delMethod")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1, 
			@RequestParam(value = "p2", required = false) String p2) {
		
		return "testHotKey............";
	}
	
	public String  delMethod(String p1, String p2, BlockException blockException) {
		
		return "delMethod...............";
	}
}
