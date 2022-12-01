package com.beratyesbek.airlinesNotification.dom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MailerNotification {

    private String receiverEmail;
    private String message;
    private BoughtTicket boughtTicket;
}
