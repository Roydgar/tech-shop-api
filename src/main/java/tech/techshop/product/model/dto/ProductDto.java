package tech.techshop.product.model.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Long price;
    private String category;
    private Boolean isAvailable;

}
