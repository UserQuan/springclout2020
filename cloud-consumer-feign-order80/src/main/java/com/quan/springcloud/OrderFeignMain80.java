package com.quan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-19 03:01
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
