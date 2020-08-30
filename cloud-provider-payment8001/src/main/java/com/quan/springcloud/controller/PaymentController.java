package com.quan.springcloud.controller;

import com.quan.springcloud.common.CommonResult;
import com.quan.springcloud.entities.PaymentDO;
import com.quan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/createPayment")
    public CommonResult createPayment(@RequestBody PaymentDO paymentDO) {
        int reslut = paymentService.createPayment(paymentDO);
        if (reslut > 0) {
            return new CommonResult("200", "success,serverPort="+serverPort, reslut);
        } else {
            return new CommonResult("444", "failed,serverPort="+serverPort, null);
        }
    }

    @RequestMapping(value = "/getPaymentById/{id}")
    public CommonResult<PaymentDO> getPaymentById(@PathVariable("id") Long id)
    {
        PaymentDO payment = paymentService.getPaymentById(id);

        if(payment != null)
        {
            return new CommonResult("200","查询成功,serverPort="+serverPort,payment);
        }else{
            return new CommonResult("444","没有对应记录,查询ID: "+id,null);
        }
    }

    @RequestMapping("/discovery")
    public Object discovery(){

        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("*****s===" + s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t"+instance.getHost()+"\t"+
                    instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to quanquan，O(∩_∩)O哈哈~";
    }

}
