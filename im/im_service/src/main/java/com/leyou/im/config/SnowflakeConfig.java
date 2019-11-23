/*
 * 作者：刘时明
 * 时间：2019/11/9-0:01
 * 作用：
 */
package com.leyou.im.config;

import com.leyou.utils.Snowflake;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowflakeConfig
{
    // 数据中心ID
    @Value("${dataCenterId}")
    private long dataCenterId;
    // 工作ID
    @Value("${workerId}")
    private long workerId;

    @Bean
    public Snowflake snowflake()
    {
        Snowflake snowflake=new Snowflake(dataCenterId,workerId);
        return snowflake;
    }
}
