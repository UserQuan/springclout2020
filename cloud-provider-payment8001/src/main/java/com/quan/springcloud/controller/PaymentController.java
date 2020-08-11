package com.quan.springcloud.controller;

import com.quan.springcloud.common.CommonResult;
import com.quan.springcloud.entities.PaymentDO;
import com.quan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-12 02:24
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping("/createPayment")
    public CommonResult createPayment(PaymentDO paymentDO) {
        int reslut = paymentService.createPayment(paymentDO);
        if (reslut > 0) {
            return new CommonResult("200", "success", reslut);
        } else {
            return new CommonResult("444", "failed", null);
        }
    }

    @RequestMapping(value = "/getPaymentById/{id}")
    public CommonResult<PaymentDO> getPaymentById(@PathVariable("id") Long id)
    {
        PaymentDO payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommonResult("200","查询成功",payment);
        }else{
            return new CommonResult("444","没有对应记录,查询ID: "+id,null);
        }
    }
}
