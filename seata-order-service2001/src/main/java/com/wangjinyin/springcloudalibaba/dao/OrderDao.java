package com.wangjinyin.springcloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wangjinyin.springcloudalibaba.domain.Order;

@Mapper
public interface OrderDao {

    //创建订单
    void create(Order order);

    //修改订单状态 从0-1
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
