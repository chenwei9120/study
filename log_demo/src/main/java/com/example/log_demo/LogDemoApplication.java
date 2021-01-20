package com.example.log_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("/log4j.properties")
public class LogDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LogDemoApplication.class, args);
        LOGGER.info("asdf");
        LOGGER.error("asdf");
    }

}
