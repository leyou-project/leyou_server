/*
 * 作者：刘时明
 * 时间：2019/11/26-23:08
 * 作用：
 */
package com.leyou.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ClusterDataSourceConfig
{
    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.leyou.data.mapper.cluster";

    @Value("${cluster.datasource.url}")
    private String url;
    @Value("${cluster.datasource.username}")
    private String user;
    @Value("${cluster.datasource.password}")
    private String password;
    @Value("${cluster.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource()
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Autowired@Qualifier("clusterDataSource") DataSource clusterDataSource)
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
