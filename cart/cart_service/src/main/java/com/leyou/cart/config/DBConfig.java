/*
 * 作者：刘时明
 * 时间：2019/11/12-23:31
 * 作用：
 */
package com.leyou.cart.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DBConfig
{
    @Bean(name = "default_dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource()
    {
        return new DruidDataSource();
    }
}
