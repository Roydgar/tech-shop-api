package tech.techshop.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.techshop.order.model.Order;
import tech.techshop.order.model.dto.OrderDto;
import tech.techshop.order.model.request.CreateOrderRequest;
import tech.techshop.order.repository.OrderRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(this::toDto)
                .collect(toList());
    }

    public OrderDto create(CreateOrderRequest request) {
        Order savedOrder = orderRepository.save(toEntity(request));
        return toDto(savedOrder);
    }

    private Order toEntity(CreateOrderRequest request) {
        Order order = new Order();
        BeanUtils.copyProperties(request, order);
        return order;
    }

    private OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }
}
