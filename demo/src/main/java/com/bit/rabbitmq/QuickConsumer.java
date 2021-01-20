package com.bit.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author chenwei
 * @version 1.0.0
 * @ClassName QuickConsumer.java
 * @Description TODO
 * @createTime 2020年03月25日 12:07:00
 */
public class QuickConsumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.78.100");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/mall");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setConnectionTimeout(1000000);

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String queueName = "way-queue-01";

        channel.queueDeclare(queueName, true, false, false, null);

        //QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
//                String routingKey = envelope.getRoutingKey();
//                String contentType = properties.getContentType();
                //long deliveryTag = envelope.getDeliveryTag();
                if(body != null) {
                    System.out.println(new String(body));
                }
                //channel.basicAck(deliveryTag, false);
            }
        };
        while(true) {
            channel.basicConsume(queueName, true, consumer);
            Thread.sleep(100);
        }
    }
}