/*
 * 作者：刘时明
 * 时间：2019/11/30-23:12
 * 作用：
 */
package com.leyou.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class RoutingConfig
{
    @Bean(name = "roundRobinDataSourceProxy")
    public AbstractRoutingDataSource roundRobinDataSourceProxy(DataSource writeDataSource,
                                                               DataSource readDataSource01,
                                                               DataSource readDataSource02)
    {

        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        //把所有数据库都放在targetDataSources中,注意key值要和determineCurrentLookupKey()中代码写的一至，
        //否则切换数据源时找不到正确的数据源
        targetDataSources.put(DataSourceType.write.getType(), writeDataSource);
        targetDataSources.put(DataSourceType.read.getType() + "1", readDataSource01);
        targetDataSources.put(DataSourceType.read.getType() + "2", readDataSource02);

        final int readSize = Integer.parseInt("2");
        //     MyAbstractRoutingDataSource proxy = new MyAbstractRoutingDataSource(readSize);

        //路由类，寻找对应的数据源
        AbstractRoutingDataSource proxy = new AbstractRoutingDataSource()
        {
            private AtomicInteger count = new AtomicInteger(0);

            /**
             * 这是AbstractRoutingDataSource类中的一个抽象方法，
             * 而它的返回值是你所要用的数据源dataSource的key值，有了这个key值，
             * targetDataSources就从中取出对应的DataSource，如果找不到，就用配置默认的数据源。
             */
            @Override
            protected Object determineCurrentLookupKey()
            {
                String typeKey = DataSourceContextHolder.getReadOrWrite();
                if (typeKey == null)
                {
                    //	System.err.println("使用数据库write.............");
                    //    return DataSourceType.write.getType();
                    throw new NullPointerException("数据库路由时，决定使用哪个数据库源类型不能为空...");
                }

                if (typeKey.equals(DataSourceType.write.getType()))
                {
                    System.err.println("使用数据库write.............");
                    return DataSourceType.write.getType();
                }
                //读库， 简单负载均衡
                int number = count.getAndAdd(1);
                int lookupKey = number % readSize;
                System.err.println("使用数据库read-" + (lookupKey + 1));
                return DataSourceType.read.getType() + (lookupKey + 1);
            }
        };
        proxy.setDefaultTargetDataSource(writeDataSource);//默认库
        proxy.setTargetDataSources(targetDataSources);
        return proxy;
    }
}
