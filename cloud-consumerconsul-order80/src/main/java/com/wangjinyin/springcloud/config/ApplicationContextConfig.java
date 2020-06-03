package com.wangjinyin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jinyin wang
 * @create 2020-04-11 13:17
 */
@Configuration
public class ApplicationContextConfig {

    @Bean 
    @LoadBalanced  //开启负载均衡
    public RestTemplate  getRestTemplate() {
        return new RestTemplate();
    }
}
