/**
 * 作者：刘时明
 * 时间：2019/11/4-16:41
 * 作用：
 */
package com.leyou.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig
{
    @Value("${spring.application.name}")
    private String serviceName;

    @Bean
    public Executor asyncServiceExecutor()
    {
        // 线程池配置固定，直接写死
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(10);
        // 配置最大线程数
        executor.setMaxPoolSize(20);
        // 配置队列大小
        executor.setQueueCapacity(500);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(serviceName + "-");
        // 如果线程池任务已满，则由调用者自己处理
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 执行初始化
        executor.initialize();
        return executor;
    }
}
