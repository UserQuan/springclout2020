package com.quan.springcloud;

import java.time.ZonedDateTime;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-27 01:52
 **/
public class TimeTest {
    public static void main(String[] args) {
        ZonedDateTime z = ZonedDateTime.now();
        System.out.println("z = " + z);
    }
}
