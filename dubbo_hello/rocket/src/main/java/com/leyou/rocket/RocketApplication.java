/*
 * 作者：刘时明
 * 时间：2019/11/24-20:59
 * 作用：
 */
package com.leyou.rocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://blog.csdn.net/bpqdwo/article/details/93209125 集群
@SpringBootApplication
public class RocketApplication
{
    public static void main(String[] args)
    {
        // https://www.cnblogs.com/kiwifly/p/11546008.html 单机
        SpringApplication.run(RocketApplication.class);
    }
}
