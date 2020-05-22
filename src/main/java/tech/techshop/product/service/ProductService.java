package tech.techshop.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.techshop.product.model.Product;
import tech.techshop.product.model.ProductDto;
import tech.techshop.product.model.mapper.ProductMapper;
import tech.techshop.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDto(products);
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No product found by id " + id));

        return productMapper.toDto(product);
    }
}
