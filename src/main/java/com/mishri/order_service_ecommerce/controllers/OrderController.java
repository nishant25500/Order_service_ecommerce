package com.mishri.order_service_ecommerce.controllers;

import com.mishri.order_service_ecommerce.dto.OrderRequestDTO;
import com.mishri.order_service_ecommerce.dto.OrderResponseDTO;
import com.mishri.order_service_ecommerce.services.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ecommerce/orders")
public class OrderController {

    private final IOrderService orderService;

    OrderController(IOrderService _orderService){
        this.orderService = _orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO request){
        return ResponseEntity.ok(this.orderService.createOrder(request));
    }
}
