package com.wangjinyin.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.hamcrest.collection.IsIterableContainingInRelativeOrder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * 自己实现负载均衡算法  cas + juc实现自旋锁
 * @author wang
 */
@Component  
public class LoadBalancerImple implements LoadBalancer{

	private AtomicInteger atomicInteger = new AtomicInteger(0);
	
	//获取是第几次访问
	private final int getAndIncrement() {
		int current;
		int next;
		//实现自旋锁
		do {
			current = this.atomicInteger.get();
			next = current >= 2147483647 ? 0:current + 1;
		} while(!this.atomicInteger.compareAndSet(current, next));
		
		System.out.println("next" + next);
		return next;
	}
	
	@Override
	public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
		
		//访问次数 % 服务数
		int index = getAndIncrement() % serviceInstances.size();
		//返回具体的服务
		return serviceInstances.get(index);
	}

}
