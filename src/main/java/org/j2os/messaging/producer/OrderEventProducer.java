package org.j2os.messaging.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.j2os.domain.event.OrderEvent;
import org.j2os.domain.mapper.OrderEventMapper;
import org.j2os.domain.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventProducer {

    private final OrderEventMapper mapper;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    public void sendOrderEvent(Order order){
        log.info("Sending order : {}", order);

        OrderEvent event = mapper.toEvent(order);
        kafkaTemplate.send(TOPIC, event.getOrderId(), event);
    }
}
