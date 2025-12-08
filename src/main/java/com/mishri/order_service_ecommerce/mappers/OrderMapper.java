package com.mishri.order_service_ecommerce.mappers;

import com.mishri.order_service_ecommerce.dto.OrderRequestDTO;
import com.mishri.order_service_ecommerce.dto.OrderResponseDTO;
import com.mishri.order_service_ecommerce.entity.Order;
import com.mishri.order_service_ecommerce.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto){
        return Order.builder()
                    .user_id(dto.getUserId())
                    .status(OrderStatus.PENDING)
                    .build();
    }

    public static OrderResponseDTO toDto(Order order){
        return OrderResponseDTO.builder()
                .orderId(order.getId())
                .status(order.getStatus())
                .build();
    }

}
