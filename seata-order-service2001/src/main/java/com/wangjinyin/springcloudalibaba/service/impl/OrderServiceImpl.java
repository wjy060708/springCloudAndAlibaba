package com.wangjinyin.springcloudalibaba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wangjinyin.springcloudalibaba.dao.OrderDao;
import com.wangjinyin.springcloudalibaba.domain.Order;
import com.wangjinyin.springcloudalibaba.service.AccountService;
import com.wangjinyin.springcloudalibaba.service.OrderService;
import com.wangjinyin.springcloudalibaba.service.StorageService;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("-------->开始创建新订单");
        orderDao.create(order);
        log.info("--------订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-------订单微服务开始调用库存，做扣减end");

        log.info("-------订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------订单微服务开始调用账户，做扣减end");
        log.info("-------修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info("-------修改订单状态结束");

        log.info("--------下订单结束了，哈哈哈哈");
    }
}
