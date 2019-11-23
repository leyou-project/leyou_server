/*
 * 作者：刘时明
 * 时间：2019/11/23-19:33
 * 作用：
 */
package com.leyou.nacos;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubbo
public class HelloApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(HelloApplication.class,args);
    }
}
