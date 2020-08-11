package com.quan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 123
 * @author: 厚浪
 * @create: 2020-08-12 01:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDO implements Serializable {
    private int id;
    private String serial;
}
