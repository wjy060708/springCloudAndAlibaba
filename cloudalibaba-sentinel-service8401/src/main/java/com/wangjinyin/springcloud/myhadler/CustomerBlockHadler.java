package com.wangjinyin.springcloud.myhadler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 
 * @author wang
 *用于创建用户自定义业务处理类
 */
public class CustomerBlockHadler {
	
	public static String hadlerException(BlockException blockException) {
		return "用户自定义业务处理方法1";
	}
	
	public static String hadlerException2(BlockException blockException) {
		return "用户自定义业务处理方法";
	}
}
