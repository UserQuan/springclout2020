package com.quan.springcloud.service;


import com.quan.springcloud.common.CommonResult;
import com.quan.springcloud.entities.PaymentDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-19 03:01
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService
{
    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult<PaymentDO> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
