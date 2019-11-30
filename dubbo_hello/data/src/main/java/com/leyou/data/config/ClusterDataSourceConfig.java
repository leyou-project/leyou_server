/*
 * 作者：刘时明
 * 时间：2019/11/26-23:08
 * 作用：
 */
package com.leyou.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class ClusterDataSourceConfig
{
    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.leyou.data.mapper.cluster";

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource(@Value("${cluster.datasource.url}") String url,
                                        @Value("${cluster.datasource.username}") String user,
                                        @Value("${cluster.datasource.password}") String password,
                                        @Value("${cluster.datasource.driverClassName}") String driverClass)
    {
        System.out.println("driverClass=" + driverClass);
        System.out.println("url=" + url);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Autowired @Qualifier("clusterDataSource") DataSource clusterDataSource)
    {
        return new DataSourceTransactionManager(clusterDataSource);
    }


    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Autowired @Qualifier("clusterDataSource") DataSource clusterDataSource) throws Exception
    {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        //sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    // 扫描mapper接口
    @Bean("clusterMapperScanner")
    public MapperScannerConfigurer getScanner()
    {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setBasePackage(PACKAGE);
        scanner.setSqlSessionFactoryBeanName("clusterSqlSessionFactory");
        return scanner;
    }
}
