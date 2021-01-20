package com.bit.annotation.dependon_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName HttpClientController.java
 * @Description TODO
 * @createTime 2020年02月23日 09:41:00
 */
@RestController
public class HttpClientController {

    @Autowired
    private HttpClient client;

    @RequestMapping("/client/hello")
    public String callHello() {
        if(client != null) {
            return client.request("http://localhost:9000/index");
        }
        return "HttpClient还没有实例化";
    }
}