/*
 * 作者：刘时明
 * 时间：2019/11/26-22:03
 * 作用：
 */
package com.leyou.gateway.config.bean;

import com.leyou.common.bean.define.ResultTask;
import com.leyou.common.bean.define.Task;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@Configuration
@EnableAsync
public class AsyncTask
{
    @Async
    public void task(Task task, Object obj)
    {
        task.taskWork(obj);
    }

    @Async
    public <E> Future<E> resultTask(ResultTask<E> task, Object obj)
    {
        return new AsyncResult<>(task.taskWork(obj));
    }
}
