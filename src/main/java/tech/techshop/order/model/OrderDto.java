package tech.techshop.order.model;

import lombok.Data;
import tech.techshop.product.model.ProductDto;

import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String consumerName;
    private String consumerEmail;
    private List<ProductDto> products;
}
