package com.mishri.order_service_ecommerce.services;

import com.mishri.order_service_ecommerce.clients.ProductServiceClient;
import com.mishri.order_service_ecommerce.dto.*;
import com.mishri.order_service_ecommerce.entity.Order;
import com.mishri.order_service_ecommerce.entity.OrderItem;
import com.mishri.order_service_ecommerce.mappers.OrderItemMapper;
import com.mishri.order_service_ecommerce.mappers.OrderMapper;
import com.mishri.order_service_ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    OrderRepository orderRepo;
    ProductServiceClient productServiceClient;

    // Constructor injection: ensures repo + client are available and testable
    OrderServiceImpl(OrderRepository repo, ProductServiceClient _productServiceClient) {
        this.orderRepo = repo;
        this.productServiceClient = _productServiceClient;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        /**
         * STEP 1: Convert incoming OrderRequestDTO → Order entity (base order details)
         * This creates an empty Order object WITHOUT its order items yet.
         * OrderItems will be attached later and saved using cascading.
         */
        Order order = OrderMapper.toEntity(request);

        /**
         * STEP 2: Extract list of items user wants to order.
         * Each item contains productId + quantity.
         */
        List<OrderItemRequestDTO> orderItemList = request.getOrderItemList();

        // Will hold converted OrderItem entities
        List<OrderItem> items = new ArrayList<>();


        for (OrderItemRequestDTO itemDTO : orderItemList) {

            // Fetch product details from Product Service (microservice call)
            ProductDTO product = productServiceClient.getProductById(itemDTO.getProductId());

            // Price per unit fetched from product microservice
            Double pricePUnit = product.getPrice();

            // Calculate total price for current item (quantity × price per unit)
            Double totPrice = pricePUnit * itemDTO.getQuantity();

            /**
             * Convert into OrderItem entity:
             * - productId
             * - quantity
             * - price_per_unit
             * - total_price
             * - reference to parent Order (for cascade save)
             */
            OrderItem item = OrderItemMapper.toEntity(itemDTO, pricePUnit, totPrice, order);

            // Collect items
            items.add(item);
        }

        /**
         * STEP 4: Attach all created OrderItems to the Order entity.
         * CascadeType.ALL ensures saving order will automatically save order items.
         */
        order.setOrderItems(items);

        /**
         * STEP 5: Save Order in DB.
         * Because cascade = ALL on Order → OrderItem,
         * both Order and all OrderItems get persisted in a single transaction.
         */
        Order createdOrder = orderRepo.save(order);

        return OrderMapper.toDto(createdOrder);
    }
}

