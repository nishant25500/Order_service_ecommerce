package com.mishri.order_service_ecommerce.dto;

import com.mishri.order_service_ecommerce.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {

    private Long orderId;

    private OrderStatus status;
}
