package com.quan.springcloud.dao;

import com.quan.springcloud.entities.PaymentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-12 01:57
 **/
@Mapper
public interface PaymentDAO {

    int createPayment(PaymentDO paymentDO);

    PaymentDO getPaymentById(@Param("id") Long id);

}
