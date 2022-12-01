package com.beratyesbek.airlinesNotification.rabbitmq;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmailNotificationSender {
    private final RabbitTemplate rabbitTemplate;
    private Queue queue;

    public void notifyService() {
        Message message = new Message("--> User has been notified".getBytes());
        rabbitTemplate.send(queue.getName(), message);
    }
}
