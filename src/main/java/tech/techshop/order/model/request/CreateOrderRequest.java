package tech.techshop.order.model.request;

import lombok.Data;
import tech.techshop.product.model.Product;

import java.util.List;

@Data
public class CreateOrderRequest {
    private String consumerName;
    private String consumerEmail;
    private List<Product> products;
}
