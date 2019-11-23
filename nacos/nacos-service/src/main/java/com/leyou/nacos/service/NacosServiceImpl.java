/*
 * 作者：刘时明
 * 时间：2019/11/23-19:36
 * 作用：
 */
package com.leyou.nacos.service;

import com.leyou.service.NacosService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0", timeout = 5000)
public class NacosServiceImpl implements NacosService
{
    @Override
    public String hello(String name)
    {
        return "hello:" + name;
    }
}
