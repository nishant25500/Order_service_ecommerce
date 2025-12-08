package com.mishri.order_service_ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderItem extends BaseEntity{

    private Long product_id;

    private Integer quantity;

    private Double price_per_unit;

    private Double total_price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
