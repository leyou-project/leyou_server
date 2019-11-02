/*
 * 作者：刘时明
 * 时间：2019/11/2-10:16
 * 作用：
 */
package com.leyou.controller;

import com.leyou.bean.Demo;
import com.leyou.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController
{
    @Autowired
    private DemoMapper demoMapper;

    @GetMapping("add")
    public Object add(String name)
    {
        Demo demo = new Demo();
        demo.setName(name);
        return demoMapper.insert(demo);
    }

    @GetMapping("get/{id}")
    public Object get(@PathVariable long id)
    {
        return demoMapper.selectById(id);
    }
}
