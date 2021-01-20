package com.example.ioc_test.config;

import com.example.ioc_test.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName StudentConfig.java
 * @Description TODO
 * @createTime 2020年04月02日 09:11:00
 */
@Configuration
public class StudentConfig {

    @Bean
    public Student student() {
        return new Student(1L, "李雷");
    }

    @Bean//(autowire = Autowire.BY_NAME)
    public Student student2() {
        return new Student(1L, "韩梅梅");
    }
}