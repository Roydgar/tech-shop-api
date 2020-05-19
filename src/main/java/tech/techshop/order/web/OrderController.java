package tech.techshop.order.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.techshop.order.model.dto.OrderDto;
import tech.techshop.order.model.request.CreateOrderRequest;
import tech.techshop.order.service.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @PostMapping
    public OrderDto save(@RequestBody CreateOrderRequest order) {
        return orderService.create(order);
    }
}
