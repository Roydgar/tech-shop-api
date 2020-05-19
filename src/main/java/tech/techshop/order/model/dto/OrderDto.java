package tech.techshop.order.model.dto;

import lombok.Data;
import tech.techshop.product.model.Product;

import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String consumerName;
    private String consumerEmail;
    private List<Product> products;
}
