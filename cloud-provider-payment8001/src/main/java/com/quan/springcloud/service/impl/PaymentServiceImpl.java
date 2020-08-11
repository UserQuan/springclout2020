package com.quan.springcloud.service.impl;

import com.quan.springcloud.dao.PaymentDAO;
import com.quan.springcloud.entities.PaymentDO;
import com.quan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-12 02:20
 **/
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDAO paymentDAO;

    public int createPayment(PaymentDO paymentDO) {
        return paymentDAO.createPayment(paymentDO);
    }

    public PaymentDO getPaymentById(Long id) {
        return paymentDAO.getPaymentById(id);
    }


}
