/*
 * 作者：刘时明
 * 时间：2019/11/24-23:36
 * 作用：
 */
package com.leyou.gateway.handler;

import com.leyou.im.service.RPCImService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("im")
public class ImHandler
{
    @Reference(version = "1.0.0")
    private RPCImService imService;

    @GetMapping("send")
    public Object get()
    {
        // imService.sendMsg();
        return null;
    }
}
