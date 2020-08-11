package com.quan.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: 厚浪
 * @create: 2020-08-12 01:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private String code;
    private String msg;
    private T data;

    public CommonResult(String code, String msg) {
        this(code,msg,null);
    }
}
