package com.beratyesbek.airlinesNotification.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailNotificationSenderConfig {

    @Value("${queue.response.name}")
    private String message;

    @Bean
    public Queue queue() {
        return new Queue(message, true);
    }

}
