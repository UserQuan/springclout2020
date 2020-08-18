package com.quan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: IRule 不能被CompomentScan扫描，否则不生效，需要用ribbonClient 指定
 * @author: 厚浪
 * @create: 2020-08-19 01:39
 **/
@Configuration
public class MySelfRule
{
    @Bean
    public IRule myRule()
    {
        return new RandomRule();//定义为随机
    }
}
