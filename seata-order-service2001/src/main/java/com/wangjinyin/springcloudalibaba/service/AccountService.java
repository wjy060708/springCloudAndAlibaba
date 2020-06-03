package com.wangjinyin.springcloudalibaba.service;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wangjinyin.springcloud.entites.CommonResult;

@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId")Long userId,
                          @RequestParam("money")BigDecimal money);
}
