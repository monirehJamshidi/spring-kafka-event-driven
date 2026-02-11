package org.j2os.domain.model;


import lombok.*;
import org.j2os.domain.enums.OrderStatus;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String product;
    private int quantity;
    private OrderStatus status;
}
