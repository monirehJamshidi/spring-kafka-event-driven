package org.j2os.domain.mapper;

import org.j2os.domain.event.OrderEvent;
import org.j2os.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEventMapper {
    public OrderEvent toEvent(Order order){
        return new OrderEvent(
                order.getOrderId(),
                order.getStatus(),
                order.getQuantity()
        );
    }
}
