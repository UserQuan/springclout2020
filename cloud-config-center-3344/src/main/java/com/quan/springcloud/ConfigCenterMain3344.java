package com.quan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description:  http://config-3344.com:3344/master/config-dev.yml
 * bus消息总线的时候，改GitHub的配置信息，调用下面命令刷新config center,
 * 然后rabbitmq广播通知3355 3366
 * curl -X POST "http://localhost:3344/actuator/bus-refresh"
 * @author: 厚浪
 * @create: 2020-08-28 01:31
 **/
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }

}
