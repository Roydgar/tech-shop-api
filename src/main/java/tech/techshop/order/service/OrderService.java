package tech.techshop.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.techshop.order.model.Order;
import tech.techshop.order.model.OrderDto;
import tech.techshop.order.model.mapper.OrderMapper;
import tech.techshop.order.model.request.CreateOrderRequest;
import tech.techshop.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDto(orders);
    }

    public OrderDto create(CreateOrderRequest request) {
        Order orderToSave = orderMapper.toEntity(request);
        Order savedOrder = orderRepository.save(orderToSave);
        return orderMapper.toDto(savedOrder);
    }
}
