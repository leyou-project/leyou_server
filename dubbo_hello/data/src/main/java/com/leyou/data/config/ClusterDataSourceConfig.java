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

    @Bean(name = "clusterDataSource1")
    public DataSource clusterDataSource1(@Value("${cluster1.datasource.url}") String url,
                                        @Value("${cluster1.datasource.username}") String user,
                                        @Value("${cluster1.datasource.password}") String password,
                                        @Value("${cluster1.datasource.driverClassName}") String driverClass)
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "clusterDataSource2")
    public DataSource clusterDataSource2(@Value("${cluster2.datasource.url}") String url,
                                        @Value("${cluster2.datasource.username}") String user,
                                        @Value("${cluster2.datasource.password}") String password,
                                        @Value("${cluster2.datasource.driverClassName}") String driverClass)
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "clusterTransactionManager1")
    public DataSourceTransactionManager clusterTransactionManager1(@Autowired @Qualifier("clusterDataSource1") DataSource clusterDataSource)
    {
        return new DataSourceTransactionManager(clusterDataSource);
    }

    @Bean(name = "clusterTransactionManager2")
    public DataSourceTransactionManager clusterTransactionManager2(@Autowired @Qualifier("clusterDataSource2") DataSource clusterDataSource)
    {
        return new DataSourceTransactionManager(clusterDataSource);
    }

    @Bean(name = "clusterSqlSessionFactory1")
    public SqlSessionFactory clusterSqlSessionFactory1(@Autowired @Qualifier("clusterDataSource1") DataSource clusterDataSource) throws Exception
    {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        //sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean(name = "clusterSqlSessionFactory2")
    public SqlSessionFactory clusterSqlSessionFactory2(@Autowired @Qualifier("clusterDataSource2") DataSource clusterDataSource) throws Exception
    {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        //sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(ClusterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    // 扫描mapper接口
    @Bean("clusterMapperScanner1")
    public MapperScannerConfigurer getScanner1()
    {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setBasePackage(PACKAGE);
        scanner.setSqlSessionFactoryBeanName("clusterSqlSessionFactory1");
        return scanner;
    }

    // 扫描mapper接口
    @Bean("clusterMapperScanner2")
    public MapperScannerConfigurer getScanner2()
    {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setBasePackage(PACKAGE);
        scanner.setSqlSessionFactoryBeanName("clusterSqlSessionFactory2");
        return scanner;
    }
}
