package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 
 * @author wang
 *
 */
@Component
@EnableBinding(Sink.class)
public class RecieveMessageController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@StreamListener(Sink.INPUT)   //监听消息接收通道
	public void inputMessage(Message<String> message) {
		System.out.println("收到的消息 :" + message.getPayload() + "\t port:" + serverPort);
	}

}
