/**
 * 作者：刘时明
 * 时间：2019/11/7-16:50
 * 作用：
 */
package com.leyou.im.handler;

import com.leyou.im.redis.define.SubscribeOperation;
import com.leyou.im.redis.RedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPubSub;

@Service
public class AsyncTask
{
    @Autowired
    private RedisTemplate template;

    @Async
    public void redisSubscribe(String channel, SubscribeOperation operation)
    {
        template.writeOperation(o ->
        {
            o.subscribe(new JedisPubSub()
            {
                @Override
                public void onMessage(String channel, String message)
                {
                    operation.onMessage(channel, message);
                }
            }, channel);
            return null;
        });
    }
}
