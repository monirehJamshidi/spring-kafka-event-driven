package org.j2os.messaging.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.j2os.domain.event.OrderEvent;
import org.j2os.service.PaymentService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentEventConsumer {

    private final PaymentService paymentService;

    @RetryableTopic(
            attempts = "3",
            backoff = @Backoff(delay = 5000),
            dltTopicSuffix = "-dlt"
    )
    @KafkaListener(
            topics = "order-topic",
            groupId = "payment-group"
    )
    public void consume(OrderEvent event){
        paymentService.processPayment(event);
    }

    @KafkaListener(topics = "order-topic-dlt")
    public void handleFailedPayment(OrderEvent event) {
        log.error("Payment permanently failed for {}", event.getOrderId());
        // notify admin
        // manual investigation
    }
}
