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
public class OrderServiceImpl implements IOrderService{

    OrderRepository orderRepo;
    ProductServiceClient productServiceClient;

    OrderServiceImpl(OrderRepository repo,ProductServiceClient _productServiceClient){
        this.orderRepo = repo;
        this.productServiceClient = _productServiceClient;
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO request){

        //step-1 persist the order in the order table

        Order order = OrderMapper.toEntity(request);

        List<OrderItemRequestDTO> orderItemList = request.getOrderItemList();

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemRequestDTO itemDTO:orderItemList){

           ProductDTO product = productServiceClient.getProductById(itemDTO.getProductId());

           Double pricePUnit = product.getPrice();

           Double totPrice = pricePUnit*itemDTO.getQuantity();

           OrderItem item = OrderItemMapper.toEntity(itemDTO,pricePUnit,totPrice,order);

           items.add(item);
        }

        order.setOrderItems(items);

        Order createdOrder = orderRepo.save(order);

        return OrderMapper.toDto(createdOrder);
    }
}
