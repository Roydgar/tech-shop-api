package tech.techshop.product.model;

import lombok.Data;
import tech.techshop.order.model.Order;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Long price;
    @Column
    private String category;
    @Column
    private Boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "product_order_id")
    private Order order;

}
