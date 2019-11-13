/**
 * 作者：刘时明
 * 时间：2019/11/7-16:02
 * 作用：
 */
package com.leyou.im.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisTemplate
{
    @Autowired
    @Qualifier("masterRedisPool")
    private JedisPool masterRedisPool;
    @Autowired
    @Qualifier("slaveRedisPool")
    private JedisPool[] slaveRedisPool;

    private int current;

    public void set(String key, String value)
    {
        Jedis jedis = masterRedisPool.getResource();
        jedis.set(key, value);
        jedis.close();
    }

    public String get(String key)
    {
        Jedis jedis = slaveRedisPool[getIndex()].getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    // 复杂的写操作
    public Object writeOperation(RedisOperation operation)
    {
        Jedis jedis = masterRedisPool.getResource();
        Object result = operation.operation(jedis);
        jedis.close();
        return result;
    }

    // 复杂的读操作
    public Object readOperation(RedisOperation operation)
    {
        Jedis jedis = slaveRedisPool[getIndex()].getResource();
        Object result = operation.operation(jedis);
        jedis.close();
        return result;
    }

    // 发布消息
    public void publish(String channel, String msg)
    {
        Jedis jedis = masterRedisPool.getResource();
        jedis.publish(channel, msg);
        jedis.close();
    }

    private int getIndex()
    {
        return (++current) % slaveRedisPool.length;
    }
}
