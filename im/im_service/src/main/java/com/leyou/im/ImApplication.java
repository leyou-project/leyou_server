/*
 * 作者：刘时明
 * 时间：2019/11/12-21:36
 * 作用：
 */
package com.leyou.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class ImApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ImApplication.class, args);
    }
}
