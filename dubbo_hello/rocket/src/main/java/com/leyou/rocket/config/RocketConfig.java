/*
 * 作者：刘时明
 * 时间：2019/11/26-0:14
 * 作用：
 */
package com.leyou.rocket.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RocketConfig
{
//    @Bean
//    public DefaultMQProducer defaultProducer() throws MQClientException
//    {
//        System.out.println("defaultProducer 正在创建---------------------------------------");
//        DefaultMQProducer producer = new DefaultMQProducer(producerConfigure.getGroupName());
//        producer.setNamesrvAddr(producerConfigure.getNamesrvAddr());
//        producer.setVipChannelEnabled(false);
//        producer.setRetryTimesWhenSendAsyncFailed(10);
//        producer.start();
//        System.out.println("rocketmq producer server开启成功--------------------------------");
//        return producer;
//    }
}
