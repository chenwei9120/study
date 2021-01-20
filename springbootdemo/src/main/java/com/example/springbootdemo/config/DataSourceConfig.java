package com.example.springbootdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.example.springbootdemo.datasource.DynamicDataSource;
import com.example.springbootdemo.enums.config.DBTypeEnum;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 关于数据源配置，参考SpringBoot官方文档第79章《Data Access》
 * 79. Data Access
 * 79.1 Configure a Custom DataSource
 * 79.2 Configure Two DataSources
 */
@Configuration
@MapperScan(basePackages = "com.example.springbootdemo.mapper")
@EnableTransactionManagement
public class DataSourceConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Autowired
    private Environment env;

    @Autowired
    private PageInterceptor pageInterceptor;

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "slave1DataSource")
    @ConfigurationProperties("spring.datasource.druid.slave1")
    public DataSource slave1DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public DynamicDataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                                 @Qualifier("slave1DataSource") DataSource slave1DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.MASTER, masterDataSource);
        targetDataSources.put(DBTypeEnum.SLAVE1, slave1DataSource);
        DynamicDataSource myRoutingDataSource = new DynamicDataSource();
        myRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        myRoutingDataSource.setTargetDataSources(targetDataSources);
        return myRoutingDataSource;
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource masterDataSource) throws Exception {
        return new DataSourceTransactionManager(masterDataSource);
    }

//    @Bean
//    public SqlSessionFactory createSqlSessionFactory(DynamicDataSource  dataSource) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(dataSource);
//        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
//        fb.setTypeAliasesPackage(typeAliasesPackage);
//        return fb.getObject();
//    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //该配置非常的重要，如果不将PageInterceptor设置到SqlSessionFactoryBean中，导致分页失效
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});
        sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
        return sqlSessionFactoryBean.getObject();
    }
}