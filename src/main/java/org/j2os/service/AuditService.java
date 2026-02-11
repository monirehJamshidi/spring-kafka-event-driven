package org.j2os.service;

import lombok.extern.slf4j.Slf4j;
import org.j2os.domain.event.OrderEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuditService {

    public void audit(OrderEvent event) {

        log.info("Audit log for order: " + event.getOrderId());

        // auditRepository.save(...)
    }
}
