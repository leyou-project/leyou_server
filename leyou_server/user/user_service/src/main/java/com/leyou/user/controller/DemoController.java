/*
 * 作者：刘时明
 * 时间：2019/11/2-10:40
 * 作用：这只是调用示例
 */
package com.leyou.user.controller;

import com.leyou.user.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("get")
    public Object get()
    {
        return "result="+userService.getUser(1);
    }
}
