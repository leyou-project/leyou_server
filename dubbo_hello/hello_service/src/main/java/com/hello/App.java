/*
 * 作者：刘时明
 * 时间：2019/11/2-0:59
 * 作用：
 */
package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class App
{
    public static void main(String[] args)
    {
        SpringApplication.run(App.class);
    }
}
