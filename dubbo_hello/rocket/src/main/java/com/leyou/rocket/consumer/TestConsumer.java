/*
 * 作者：刘时明
 * 时间：2019/11/27-23:50
 * 作用：
 */
package com.leyou.rocket.consumer;

import com.leyou.rocket.config.RocketConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TestConsumer extends RocketConfig implements ApplicationListener<ContextRefreshedEvent>
{
    @Override
    public ConsumeConcurrentlyStatus consume(List<MessageExt> msg)
    {
        msg.forEach(e ->
        {
            log.info("Consume Msg :{}", new String(e.getBody()));
        });
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        try
        {
            defaultMQPushConsumer();
            log.info("消费者就绪...");
        } catch (MQClientException e)
        {
            log.error("defaultMQPushConsumer fail,error={}", e.getMessage());
        }
    }
}
