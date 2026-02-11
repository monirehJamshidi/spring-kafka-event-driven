package org.j2os.api;

import lombok.RequiredArgsConstructor;
import org.j2os.domain.enums.OrderStatus;
import org.j2os.domain.model.Order;
import org.j2os.messaging.producer.OrderEventProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderEventProducer producer;

    @PostMapping
    public String createOrder(){
        Order order = new Order(
                "ORDER-1",
                "Laptop",
                2,
                OrderStatus.CREATED
        );

        producer.sendOrderEvent(order);

        return "OK";
    }

}
