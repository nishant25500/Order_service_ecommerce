package com.mishri.order_service_ecommerce.mappers;

import com.mishri.order_service_ecommerce.dto.OrderItemRequestDTO;
import com.mishri.order_service_ecommerce.entity.Order;
import com.mishri.order_service_ecommerce.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem toEntity(OrderItemRequestDTO itemDto, Double pricePUnit, Double totPrice, Order order){
        return OrderItem.builder()
                .product_id(itemDto.getProductId())
                .quantity(itemDto.getQuantity())
                .price_per_unit(pricePUnit)
                .total_price(totPrice)
                .order(order)
                .build();
    }
}
