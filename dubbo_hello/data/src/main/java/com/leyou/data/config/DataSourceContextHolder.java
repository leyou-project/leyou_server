/*
 * 作者：刘时明
 * 时间：2019/11/30-23:19
 * 作用：
 */
package com.leyou.data.config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceContextHolder
{
    //线程本地环境
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal()
    {
        return local;
    }

    /**
     * 读库
     */
    public static void setRead()
    {
        local.set(DataSourceType.read.getType());
        log.info("数据库切换到读库...");
    }

    /**
     * 写库
     */
    public static void setWrite()
    {
        local.set(DataSourceType.write.getType());
        log.info("数据库切换到写库...");
    }

    public static String getReadOrWrite()
    {
        return local.get();
    }

    public static void clear()
    {
        local.remove();
    }
}
