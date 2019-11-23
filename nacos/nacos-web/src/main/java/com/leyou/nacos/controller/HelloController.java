/*
 * 作者：刘时明
 * 时间：2019/11/23-19:57
 * 作用：
 */
package com.leyou.nacos.controller;

import com.leyou.service.NacosService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Reference(version = "1.0.0")
    NacosService nacosService;

    @GetMapping("hello")
    public Object hello(String name)
    {
        return nacosService.hello(name);
    }
}
