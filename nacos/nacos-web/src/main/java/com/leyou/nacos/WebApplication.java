/*
 * 作者：刘时明
 * 时间：2019/11/23-19:53
 * 作用：
 */
package com.leyou.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WebApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(WebApplication.class, args);
    }
}
