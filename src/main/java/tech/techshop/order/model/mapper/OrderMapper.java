package tech.techshop.order.model.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tech.techshop.order.model.Order;
import tech.techshop.order.model.OrderDto;
import tech.techshop.order.model.request.CreateOrderRequest;
import tech.techshop.product.model.mapper.ProductMapper;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class OrderMapper {
    private final ProductMapper productMapper;

    public Order toEntity(CreateOrderRequest request) {
        Order order = new Order();
        BeanUtils.copyProperties(request, order, "products");

        order.setProducts(productMapper.toEntity(request.getProducts()));
        return order;
    }

    public List<OrderDto> toDto(List<Order> orders) {
        return orders.stream()
                .map(this::toDto)
                .collect(toList());
    }

    public OrderDto toDto(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto, "products");

        orderDto.setProducts(productMapper.toDto(order.getProducts()));
        return orderDto;
    }
}
