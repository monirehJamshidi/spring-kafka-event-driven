package org.j2os.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.j2os.domain.enums.OrderStatus;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class OrderEvent {
    private String orderId;
    private OrderStatus orderStatus;
    private int quantity;

    public OrderEvent() {

    }

    public OrderEvent(String orderId, OrderStatus status, int quantity){
        this.orderId = orderId;
        this.orderStatus = status;
        this.quantity = quantity;
    }


}
