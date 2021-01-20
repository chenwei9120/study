package com.bit.annotation.dependon_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HttpClient.java
 * @Description TODO
 * @createTime 2020年02月23日 09:31:00
 */
//测试@DependsOn注解
@Component
@DependsOn("restTemplate")
public class HttpClient {

    @Autowired
    private RestTemplate restTemplate;

    public String request(String url) {
        if(restTemplate != null) {
            System.out.println("restTemplate is not null");
        } else {
            System.out.println("restTemplate is null");
        }
        return restTemplate.getForObject(url, String.class);
    }
}