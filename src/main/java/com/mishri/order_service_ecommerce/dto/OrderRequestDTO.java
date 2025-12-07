package com.mishri.order_service_ecommerce.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {
    private Long userId;
    private List<OrderItemRequestDTO> orderItemList;
}
