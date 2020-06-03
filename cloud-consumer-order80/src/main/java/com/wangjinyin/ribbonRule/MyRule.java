package com.wangjinyin.ribbonRule;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * ribbon共有7种负载均衡策略
 * ribbon官方文档强调 ，不能被@ComponentScan扫描到
 * @author wang
 *
 */
@Configuration
public class MyRule {

	@Bean
	public IRule myIRule() {
		return new RandomRule(); //随机
	}
}
