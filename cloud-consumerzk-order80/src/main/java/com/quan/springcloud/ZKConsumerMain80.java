package com.quan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-18 01:02
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ZKConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(ZKConsumerMain80.class, args);
    }
}
