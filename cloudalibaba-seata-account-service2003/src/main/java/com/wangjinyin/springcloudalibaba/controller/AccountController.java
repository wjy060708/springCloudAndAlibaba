package com.wangjinyin.springcloudalibaba.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloudalibaba.service.AccountService;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping(value = "decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                                 @RequestParam("money")BigDecimal money) {
        accountService.decrease(userId, money);
        return new CommonResult(200,"账户余额扣减成功，哈哈哈");
    }
}
