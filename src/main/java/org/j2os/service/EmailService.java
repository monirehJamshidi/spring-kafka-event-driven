package org.j2os.service;

import lombok.extern.slf4j.Slf4j;
import org.j2os.domain.event.OrderEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {
    public void sendEmail(OrderEvent event) {

        log.info("Sending email for order: "
                + event.getOrderId());

        String message = "Your order " + event.getOrderId() + " is created.";

        // emailSender.send(message);
    }
}
