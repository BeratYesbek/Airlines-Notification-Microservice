package com.beratyesbek.airlinesNotification.rabbitmq;

import com.beratyesbek.airlinesNotification.dom.BoughtTicket;
import com.beratyesbek.airlinesNotification.dom.MailerNotification;
import com.beratyesbek.airlinesNotification.services.abstracts.MailerNotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Component
public class EmailNotificationConsumer {

    private final MailerNotificationService notificationService;

    public EmailNotificationConsumer(MailerNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String body, @Headers Map<String, Object> headers) {
        MailerNotification notification = MailerNotification.builder()
                .receiverEmail(headers.get("userEmail").toString())
                .message(body)
                .boughtTicket
                        (
                                BoughtTicket.builder()
                                        .userEmail(headers.get("userEmail").toString())
                                        .from(headers.get("from").toString())
                                        .to(headers.get("to").toString())
                                        //.price(new BigDecimal(headers.get("price").toString()))
                                        .phoneNumber(headers.get("phoneNumber").toString()).build()
                        ).build();

        notificationService.notify(notification);
    }
}
