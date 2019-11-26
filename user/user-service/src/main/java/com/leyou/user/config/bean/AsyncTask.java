/*
 * 作者：刘时明
 * 时间：2019/11/26-22:03
 * 作用：
 */
package com.leyou.user.config.bean;

import com.leyou.common.bean.define.Task;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.scheduling.annotation.Async;

@Service
public class AsyncTask
{
    @Async
    public void task(Task task)
    {
        task.taskWork();
    }
}
