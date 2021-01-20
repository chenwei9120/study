package com.example.springbootdemo.mq;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName ConsumerListener.java
 * @Description TODO
 * @createTime 2019年11月08日 12:09:00
 */
@Component
public class ConsumerListener {

//    @KafkaListener(topics = "topic1")
//    public void onMessage(String message){
//        //insertIntoDb(buffer);//这里为插入数据库代码
//        System.out.println(message);
//    }
}