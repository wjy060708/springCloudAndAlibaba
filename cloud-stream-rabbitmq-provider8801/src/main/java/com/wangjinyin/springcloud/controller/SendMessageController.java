package com.wangjinyin.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.service.IMessageProvider;

@RestController
public class SendMessageController {

	@Autowired
	private IMessageProvider iMessageProvider;
	
	@RequestMapping("/sendMessage")
	public String sendMessage() {
		return iMessageProvider.send();
	}
}
