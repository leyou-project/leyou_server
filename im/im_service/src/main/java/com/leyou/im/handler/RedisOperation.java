/**
 * 作者：刘时明
 * 时间：2019/11/7-16:22
 * 作用：
 */
package com.leyou.im.handler;

import redis.clients.jedis.Jedis;

@FunctionalInterface
public interface RedisOperation
{
    Object operation(Jedis jedis);
}
