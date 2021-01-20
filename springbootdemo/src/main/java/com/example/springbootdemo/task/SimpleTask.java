package com.example.springbootdemo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName SimpleTask.java
 * @Description TODO
 * @createTime 2019年10月29日 10:48:00
 */
@Slf4j
@Configuration
@EnableScheduling
public class SimpleTask {
    @Scheduled(cron = "0 50 10 27-29 10 ?")
    private void dataExport() {
        System.out.println("dsdddddddddddddd");
    }
}