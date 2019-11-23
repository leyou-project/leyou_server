/*
 * 作者：刘时明
 * 时间：2019/11/23-20:26
 * 作用：
 */
package com.leyou.nacos.config;

import org.apache.dubbo.config.MetadataReportConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetaConfig
{
    @Value("${nacos.service-address}")
    private String address;
    @Value("${nacos.port}")
    private Integer port;

    @Bean
    public MetadataReportConfig metadataReportConfig()
    {
        MetadataReportConfig config = new MetadataReportConfig();
        config.setAddress(String.format("nacos://%s:%d", address, port));
        return config;
    }
}
