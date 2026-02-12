package org.j2os.service;

import lombok.extern.slf4j.Slf4j;
import org.j2os.domain.event.OrderEvent;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public void processPayment(OrderEvent event){

        if (Math.random() > 0.5){
            throw new RuntimeException("Payment gateway failed");
        }

        log.info("Processing payment for order: " + event.getOrderId());

        // business logic
        if ("CREATED".equals(event.getOrderStatus())) {
            log.info("Payment completed");
        }

//        paymentRepository.save(...)
//        paymentGateway.charge(...)

    }
}
