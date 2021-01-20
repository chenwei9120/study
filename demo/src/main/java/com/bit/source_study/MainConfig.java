package com.bit.source_study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;


@Configuration
@Import(value = {TulingService.class})
@ComponentScan(basePackages = "com.bit.source_study")
public class MainConfig {

    private Computer computer = null;

    @Bean
    public TulingDataSource tulingDataSource() {
        return new TulingDataSource();
    }

    @Bean(name = "PC")
    //@AliasFor()
    public synchronized Computer computer() {
        if(computer == null) {
            computer = new Computer();
        }
        return computer;
    }

    @Bean(name="Laptop")
    //@AliasFor("")
    public synchronized Computer computer2() {
        if(computer == null) {
            computer = new Computer();
        }
        return computer;
    }
}
