/*
 * 作者：刘时明
 * 时间：2019/11/27-22:52
 * 作用：
 */
package com.leyou.rocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController
{
    @Autowired
    private DefaultMQProducer producer;

    @GetMapping("send")
    public Object send() throws RemotingException, MQClientException, InterruptedException
    {
        Message message=new Message();
        message.setTopic("leyou-test");
        message.setTags("tag1");
        message.setKeys("12345");
        message.setBody("hello world".getBytes());
        producer.send(message, new SendCallback()
        {
            @Override
            public void onSuccess(SendResult sendResult)
            {
                log.info("消息成功发送，消息ID={}",sendResult.getMsgId());
            }

            @Override
            public void onException(Throwable throwable)
            {
                log.error("消息成功失败，error={}",throwable.getMessage());
            }
        });
        return "ok";
    }
}
