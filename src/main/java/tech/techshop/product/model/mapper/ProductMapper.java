package tech.techshop.product.model.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import tech.techshop.product.model.Product;
import tech.techshop.product.model.ProductDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ProductMapper {

    public List<ProductDto> toDto(List<Product> product) {
        return product.stream()
                .map(this::toDto)
                .collect(toList());
    }

    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public List<Product> toEntity(List<ProductDto> productDtos) {
        return productDtos.stream()
                .map(this::toEntity)
                .collect(toList());
    }

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }
}
