package com.wangjinyin.springcloudalibaba.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wangjinyin.springcloud.entites.CommonResult;
import com.wangjinyin.springcloudalibaba.service.StorageService;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value = "/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"库存扣减成功，哈哈哈哈");
    }
}
