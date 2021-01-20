package com.bit.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName QuickProducer.java
 * @Description TODO
 * @createTime 2020年03月25日 12:07:00
 */
public class QuickProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.78.100");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/mall");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setConnectionTimeout(1000000);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        for (int i = 0; i < 5; i++) {
            String message = "hell--" + i;
            /*"/"The default exchange is implicitly bound to every queue,
             with a routing key equal to the queue name. It is not possible
             to explicitly bind to, or unbind from the default exchange.
             It also cannot be deleted.*/
            //channel.basicPublish("/","way-queue-01", null, message.getBytes());
            channel.basicPublish("/","way-queue-01", null, message.getBytes());
        }
        channel.close();
        connection.close();
    }
}