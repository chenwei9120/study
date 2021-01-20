package com.example.config;

import com.example.model.Car;
import com.example.model.Address;
import com.example.test.SchoolFactory;
import org.springframework.context.annotation.*;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName MainConfig.java
 * @Description TODO
 * @createTime 2019年11月11日 16:36:00
 */
@Configuration
//@Import相当于@Bean的作用
//注意包的扫描，用import引用FactoryBean的实现类的对象时，如果去掉包扫描就会出问题。
@Import({Address.class, SchoolFactory.class})
//@Import({Address.class})
@ComponentScan({"com.example.test"})
public class MainConfig {

    @Bean
   // @Scope("prototype")
    public Car car() {
        return new Car();
    }
}