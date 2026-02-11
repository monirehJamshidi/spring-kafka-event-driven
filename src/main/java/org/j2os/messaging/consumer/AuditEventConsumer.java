package org.j2os.messaging.consumer;

import lombok.RequiredArgsConstructor;
import org.j2os.domain.event.OrderEvent;
import org.j2os.service.AuditService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuditEventConsumer {

    private final AuditService auditService;

    @KafkaListener(
            topics = "order-topic",
            groupId = "audit-group"
    )
    public void consume(OrderEvent event){
        auditService.audit(event);
    }
}
