package com.mishri.order_service_ecommerce.controllers;

import com.mishri.order_service_ecommerce.dto.OrderRequestDTO;
import com.mishri.order_service_ecommerce.dto.OrderResponseDTO;
import com.mishri.order_service_ecommerce.services.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ecommerce/order")
public class OrderController {

    IOrderService orderService;

    OrderController(IOrderService _orderService){
        this.orderService = _orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(OrderRequestDTO order){
        return ResponseEntity.ok(this.orderService.createOrder(order));
    }
}
