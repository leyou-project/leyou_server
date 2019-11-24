/*
 * 作者：刘时明
 * 时间：2019/11/24-0:10
 * 作用：
 */
package com.leyou.logs;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class LogsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(LogsApplication.class, args);
    }
}
