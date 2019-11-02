/*
 * 作者：刘时明
 * 时间：2019/11/2-1:12
 * 作用：
 */
package com.hello.controller;

import com.hello.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Reference(version = "1.0.0")
    private HelloService helloService;

    @GetMapping("hello")
    public Object hello()
    {
        return helloService.hello();
    }
}
