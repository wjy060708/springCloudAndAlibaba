package com.wangjinyin.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangjinyin.springcloud.dao.PaymentDao;
import com.wangjinyin.springcloud.entites.Payment;
import com.wangjinyin.springcloud.service.PaymentService;

/**
 * @author jinyin wang
 * @create 2020-04-09 22:12
 */
@Service
public class PaymentServceImpl  implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
