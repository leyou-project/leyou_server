package com.leyou.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 作者：刘时明
 * 时间：2019/11/4-18:48
 * 作用：
 */

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ImApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ImApplication.class);
    }
}
