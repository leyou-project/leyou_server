/*
 * 作者：刘时明
 * 时间：2019/11/2-0:57
 * 作用：
 */
package com.hello.service.impl;

import com.hello.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(timeout = 5000, version = "1.0.0")
public class HelloServiceImpl implements HelloService
{
    @Override
    public String hello()
    {
        return "hello world!!!";
    }
}
