package tech.techshop.order.model;

import lombok.Data;
import tech.techshop.product.model.Product;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "product_order")
public class Order {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String consumerName;
    @Column
    private String consumerEmail;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Product> products;

}
