package com.mishri.order_service_ecommerce.services;

import com.mishri.order_service_ecommerce.dto.OrderRequestDTO;
import com.mishri.order_service_ecommerce.dto.OrderResponseDTO;

public interface IOrderService {
    OrderResponseDTO createOrder(OrderRequestDTO order);
}
