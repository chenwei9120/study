package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName KafkaController.java
 * @Description TODO
 * @createTime 2019年11月08日 12:08:00
 */
@RestController
public class KafkaController {

    @Autowired(required = false)
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/message/send")
    public boolean send(@RequestParam String message){
        kafkaTemplate.send("topic1",message);
        return true;
    }

}