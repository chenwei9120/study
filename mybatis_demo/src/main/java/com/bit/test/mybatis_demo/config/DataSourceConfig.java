package com.bit.test.mybatis_demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName DataSourceConfig.java
 * @Description TODO
 * @createTime 2019年11月05日 17:16:00
 */
@Configuration
@MapperScan("com.bit.test.mybatis_demo.mappers")
@EnableTransactionManagement
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private Environment env;

    @Autowired
    private PageInterceptor pageInterceptor;

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    //@ConfigurationProperties(prefix = "test", locations = "classpath:xxxx.properties")
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

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