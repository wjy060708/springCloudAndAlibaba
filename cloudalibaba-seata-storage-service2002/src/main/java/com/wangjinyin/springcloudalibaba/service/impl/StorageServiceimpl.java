package com.wangjinyin.springcloudalibaba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wangjinyin.springcloudalibaba.dao.StorageDao;
import com.wangjinyin.springcloudalibaba.service.StorageService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StorageServiceimpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("库存扣减开始----");
        storageDao.decrease(productId,count);
        log.info("库存扣减结束----");
    }
}
