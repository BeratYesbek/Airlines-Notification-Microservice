package com.beratyesbek.airlinesNotification.dom;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class BoughtTicket {

    private int id;
    private int externalId;
    private String from;
    private String to;
    private String userEmail;
    private String phoneNumber;
    private BigDecimal price;
    private Date flightDate;

}
