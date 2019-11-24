/*
 * 作者：刘时明
 * 时间：2019/11/12-21:36
 * 作用：
 */
package com.leyou.im;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class ImApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ImApplication.class);
    }
}
