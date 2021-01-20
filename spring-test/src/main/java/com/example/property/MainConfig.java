package com.example.property;

import com.example.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by way on 2019/5/19.
 */
@Configuration
@PropertySource(value = {"classpath:person.properties"})
public class MainConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
