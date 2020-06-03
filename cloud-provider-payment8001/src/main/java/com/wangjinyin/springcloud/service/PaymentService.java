package com.wangjinyin.springcloud.service;

import org.apache.ibatis.annotations.Param;

import com.wangjinyin.springcloud.entites.Payment;

/**
 * @author jinyin wang
 * @create 2020-04-09 22:12
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
