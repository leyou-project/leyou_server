/*
 * 作者：刘时明
 * 时间：2019/11/26-0:14
 * 作用：
 */
package com.leyou.rocket.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

@Slf4j
@Configuration
public abstract class RocketConfig
{
    @Value("${rocketmq.producer.groupName}")
    private String groupName;
    @Value("${rocketmq.producer.namesrvAddr}")
    private String serverAddr;

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException
    {
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(serverAddr);
        producer.setRetryTimesWhenSendFailed(10);
        producer.start();
        log.info("rocketmq defaultMQProducer start...");
        return producer;
    }

    public void defaultMQPushConsumer() throws MQClientException
    {
        // 不知道消费组名就会报错
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("CID_LRW_DEV_SUBS");
        consumer.setNamesrvAddr(serverAddr);
        consumer.subscribe("leyou-test", "tag1");
        consumer.registerMessageListener(new MessageListenerConcurrently()
        {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext)
            {
                return RocketConfig.this.consume(list);
            }
        });
        consumer.start();
        log.info("rocketmq defaultMQPushConsumer start...");
    }

    public abstract ConsumeConcurrentlyStatus consume(List<MessageExt> msg);
}
