/*
 * 作者：刘时明
 * 时间：2019/11/26-23:03
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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class MasterDataSourceConfig
{
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.leyou.data.mapper.master";

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource(@Value("${cluster.datasource.url}") String url,
                                       @Value("${cluster.datasource.username}") String user,
                                       @Value("${cluster.datasource.password}") String password,
                                       @Value("${cluster.datasource.driverClassName}") String driverClass)
    {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;

    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager(@Autowired @Qualifier("masterDataSource") DataSource masterDataSource)
    {
        return new DataSourceTransactionManager(masterDataSource);
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Autowired @Qualifier("masterDataSource") DataSource masterDataSource) throws Exception
    {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        //sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    // 扫描mapper接口
    @Bean("masterMapperScanner")
    public MapperScannerConfigurer getScanner()
    {
        MapperScannerConfigurer scanner = new MapperScannerConfigurer();
        scanner.setBasePackage(PACKAGE);
        scanner.setSqlSessionFactoryBeanName("masterSqlSessionFactory");
        return scanner;
    }
}
