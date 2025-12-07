package com.mishri.order_service_ecommerce.services;

import com.mishri.order_service_ecommerce.dto.OrderRequestDTO;
import com.mishri.order_service_ecommerce.dto.OrderResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO order){


        return null;
    }
}
