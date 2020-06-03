package com.wangjinyin.springcloud.filter;

import java.util.Date;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class MyLogFilter implements GlobalFilter, Ordered{

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		System.out.println("come in 全局过滤器" + new Date());
		String userName = exchange.getRequest().getQueryParams().getFirst("username");
		
		if (userName == null) {
			System.out.println("用户名为" + userName + "非法用户 ");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}
}
