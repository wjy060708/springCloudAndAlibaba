package com.wangjinyin.springcloudalibaba.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloudalibaba.domain.Order;
import com.wangjinyin.springcloudalibaba.service.OrderService;


@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功！");
    }
}
