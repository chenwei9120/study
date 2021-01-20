package com.bit.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ZookeeperConfig
 * @Description TODO
 * @createTime 2020-12-25 17:02:00
 */
@Configuration
public class ZookeeperConfig {
    @Value("${mg.characterZookeeper}")
    private String zkAddress;

    @Bean(value = "zkClient")
    public CuratorFramework curatorFramework(RetryNTimes retryNTimes) {

        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .sessionTimeoutMs(10000)
                .connectionTimeoutMs(10000)
                .connectString(zkAddress).retryPolicy(retryNTimes).build();
        curatorFramework.start();
        return curatorFramework;

    }

    @Bean
    public RetryNTimes retryNTimes() {
        RetryNTimes retryNTimes = new RetryNTimes(3600, 1000);
        return retryNTimes;
    }
}
