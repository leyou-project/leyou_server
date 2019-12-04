/*
 * 作者：刘时明
 * 时间：2019/11/24-23:36
 * 作用：
 */
package com.leyou.gateway.handler;

import com.leyou.gateway.aspect.annotation.LogInterceptJoinPoint;
import com.leyou.gateway.config.bean.AsyncTask;
import com.leyou.im.service.RPCImService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/im")
public class ImHandler
{
    @Reference(version = "1.0.0", check = false)
    private RPCImService imService;
    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("send")
    public Object get()
    {
        // imService.sendMsg();
        return "hello";
    }

    @LogInterceptJoinPoint
    @GetMapping("async")
    public Object async()
    {
        asyncTask.task((obj) ->
                {
                    System.out.println("in taskWork:" + System.currentTimeMillis());
                    try
                    {
                        Thread.sleep(5000);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("out taskWork:" + System.currentTimeMillis());
                }
                , 1234);
        return "ok";
    }
}
