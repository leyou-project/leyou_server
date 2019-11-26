/*
 * 作者：刘时明
 * 时间：2019/11/26-23:24
 * 作用：
 */
package com.leyou.data.controller;

import com.leyou.data.service.TempServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController
{
    @Autowired
    private TempServiceImpl service;

    @GetMapping("save")
    public Object save(int id,String name)
    {
        return service.save(id, name);
    }

    @GetMapping("list")
    public Object list()
    {
        return service.list();
    }
}
