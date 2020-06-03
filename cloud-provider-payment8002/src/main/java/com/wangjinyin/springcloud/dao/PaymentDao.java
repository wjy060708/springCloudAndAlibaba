package com.wangjinyin.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wangjinyin.springcloud.entites.Payment;

/**
 * @author jinyin wang
 * @create 2020-04-09 21:56
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
