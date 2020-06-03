package com.wangjinyin.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.wangjinyin.springcloud.service.IMessageProvider;

import cn.hutool.core.lang.UUID;

@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageServiceImpl implements IMessageProvider{

	@Autowired
	private MessageChannel output; //定义消息发送通道
	
	@Override
	public String send() {
		
		String serial = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(serial).build());
		return serial;
	}
}
