/*
 * 作者：刘时明
 * 时间：2019/11/26-21:24
 * 作用：
 */
package com.leyou.gateway.handler;

import com.leyou.logs.service.RPCLogsService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/logs")
public class LogsHandler
{
    @Reference(version = "1.0.0",check = false)
    private RPCLogsService logsService;
}
