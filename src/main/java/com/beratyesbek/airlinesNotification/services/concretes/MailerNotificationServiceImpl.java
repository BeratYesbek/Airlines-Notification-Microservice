package com.beratyesbek.airlinesNotification.services.concretes;

import com.beratyesbek.airlinesNotification.dom.MailerNotification;
import com.beratyesbek.airlinesNotification.rabbitmq.EmailNotificationSender;
import com.beratyesbek.airlinesNotification.services.abstracts.MailerNotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MailerNotificationServiceImpl implements MailerNotificationService {

    private final JavaMailSender mailSender;
    private final EmailNotificationSender emailNotificationSender;
    private final String from = "do.not.reply.feedopt@gmail.com";

    @Override
    public void notify(MailerNotification notify) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(notify.getBoughtTicket().getUserEmail());
        message.setText(notify.getMessage());
        mailSender.send(message);
        emailNotificationSender.notifyService();
    }
}
