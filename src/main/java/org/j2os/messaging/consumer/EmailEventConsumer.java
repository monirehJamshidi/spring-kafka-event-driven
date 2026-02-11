package org.j2os.messaging.consumer;

import lombok.RequiredArgsConstructor;
import org.j2os.domain.event.OrderEvent;
import org.j2os.service.EmailService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailEventConsumer {

    private final EmailService emailService;

    @KafkaListener(
            topics = "order-topic",
            groupId = "order-topic"
    )
    public void comsume(OrderEvent event) {
        emailService.sendEmail(event);
    }
}
