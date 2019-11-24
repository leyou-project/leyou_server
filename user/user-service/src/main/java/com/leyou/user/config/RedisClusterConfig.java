/**
 * 作者：刘时明
 * 时间：2019/11/7-11:36
 * 作用：
 */
package com.leyou.user.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

@Configuration
public class RedisClusterConfig
{
    @Value("${spring.redis.sentinel.master}")
    private String master;
    @Value("${spring.redis.sentinel.slave}")
    private String slave;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.database}")
    private Integer database;
    @Value("${spring.redis.timeout}")
    private Integer timeout;
    @Value("${spring.redis.max-wait}")
    private Integer maxWait;
    @Value("${spring.redis.max-idle}")
    private Integer maxIdle;
    @Value("${spring.redis.min-idle}")
    private Integer minIdle;
    @Value("${spring.redis.max-active}")
    private Integer maxActive;

    @Bean(name = "masterRedisPool")
    public JedisPool masterRedisPool()
    {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxTotal(maxActive);
        config.setMaxWaitMillis(maxWait);
        String[] arr = master.split(":");
        JedisPool pool = new JedisPool(config, arr[0], Integer.parseInt(arr[1]), timeout, password);
        return pool;
    }

    @Bean(name = "slaveRedisPool")
    public JedisPool[] slaveRedisPool()
    {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxTotal(maxActive);
        config.setMaxWaitMillis(maxWait);
        String[] urls = slave.split(",");
        JedisPool[] pools = new JedisPool[urls.length];
        for (int i = 0; i < urls.length; i++)
        {
            String[] arr = urls[i].split(":");
            pools[i] = new JedisPool(config, arr[0], Integer.parseInt(arr[1]), timeout, password);
        }
        return pools;
    }
}
