package org.j2os.messaging.consumer;

import lombok.RequiredArgsConstructor;
import org.j2os.domain.event.OrderEvent;
import org.j2os.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentEventConsumer {

    private final PaymentService paymentService;

    @KafkaListener(
            topics = "order-topic",
            groupId = "payment-group"
    )
    public void consume(OrderEvent event){
        paymentService.processPayment(event);
    }
}
