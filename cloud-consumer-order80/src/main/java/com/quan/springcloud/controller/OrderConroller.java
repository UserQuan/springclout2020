package com.quan.springcloud.controller;

import com.quan.springcloud.common.CommonResult;
import com.quan.springcloud.entities.PaymentDO;
import com.quan.springcloud.lb.LoadBalancer;
import com.quan.springcloud.lb.MyLB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-13 01:59
 **/
@RestController
@Slf4j
//@RequestMapping("/consumer")
public class OrderConroller {

    //单机
//    public static final String PAYMENT_URL = "http://localhost:8001";

    //集群
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/consumer/payment/createPayment")
    public CommonResult<PaymentDO> create( PaymentDO paymentDO) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/createPayment", paymentDO, CommonResult.class);
    }

    @RequestMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult<PaymentDO> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<PaymentDO> getPayment2(@PathVariable("id") Long id)
    {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
        return entity.getBody();
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if (instances == null || instances.size() < 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }
    // ====================> zipkin+sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin/", String.class);
        return result;
    }

}
