package com.wangjinyin.springcloudalibaba.service.impl;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wangjinyin.springcloudalibaba.dao.AccountDao;
import com.wangjinyin.springcloudalibaba.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("账户扣除余额开始---");
        //模拟超时异常
    
		/*
		 * try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
        accountDao.decrease(userId, money);
        log.info("账户扣除余额结束---");
    }
}
