/*
 * 作者：刘时明
 * 时间：2019/11/22-22:42
 * 作用：
 */
package com.leyou.goods.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.dubbo.config.MetadataReportConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboConfig
{
    @Bean
    public MetadataReportConfig metadataReportConfig()
    {
        MetadataReportConfig metadataReportConfig = new MetadataReportConfig();
        metadataReportConfig.setAddress("zookeeper://114.116.239.108:2181");
        return metadataReportConfig;
    }

    public void init() throws Exception
    {
        CuratorFramework zkClient = CuratorFrameworkFactory.builder().
                connectString("114.116.239.108:2181").
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        zkClient.start();

        if (zkClient.checkExists().forPath("/dubbo/config/dubbo/dubbo.properties") == null)
        {
            zkClient.create().creatingParentsIfNeeded().forPath("/dubbo/config/dubbo/dubbo.properties");
        }
        zkClient.setData().forPath("/dubbo/config/dubbo/dubbo.properties", ("dubbo.registry.address=zookeeper://114.116.239.108:2181\n" +
                "dubbo.metadata-report.address=zookeeper://114.116.239.108:2181").getBytes());
    }
}
