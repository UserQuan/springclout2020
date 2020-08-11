package com.quan.springcloud.service;

import com.quan.springcloud.entities.PaymentDO;

/**
 * @description:12312
 * @author: 厚浪
 * @create: 2020-08-12 02:18
 **/
public interface PaymentService {

     int createPayment(PaymentDO paymentDO);

     PaymentDO getPaymentById(Long id);
}
