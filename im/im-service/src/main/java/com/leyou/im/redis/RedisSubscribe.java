/**
 * 作者：刘时明
 * 时间：2019/11/7-17:01
 * 作用：
 */
package com.leyou.im.redis;

import com.leyou.im.handler.AsyncTask;
import com.leyou.im.handler.message.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class RedisSubscribe
{
    @Autowired
    private AsyncTask task;
    @Value("${chat.subTopic}")
    private String subTopic;

    @Autowired
    private MessageHandler messageHandler;

    @PostConstruct
    public void subscribe()
    {
        // 消息订阅
        task.redisSubscribe(subTopic,(channel, message) -> messageHandler.message(message));
    }
}
