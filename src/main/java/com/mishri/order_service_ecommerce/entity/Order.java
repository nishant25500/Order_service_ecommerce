package com.mishri.order_service_ecommerce.entity;

import com.mishri.order_service_ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="orders")  //coz order is also a keyword in mysql
public class Order extends BaseEntity{

    private Long user_id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;
}
