package org.j2os.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.j2os.domain.event.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderEventConsumer {

    @KafkaListener(
            topics = "order-topic",
            groupId = "order-group-v3"
    )
    public void consume(OrderEvent event){
        log.info("Received order event: {}", event);

        //business logic
        processOrder(event);
    }

    private void processOrder(OrderEvent event){
        log.info("Processing order {}", event.getOrderId());

        //save to DB
        //call payment service
        //send notification
    }
}
