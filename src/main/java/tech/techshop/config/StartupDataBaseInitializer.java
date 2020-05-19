package tech.techshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.techshop.product.model.Product;
import tech.techshop.product.repository.ProductRepository;

// Runs on app startup (after the Spring context is initialized) in order to create test data in the db
@Component
@RequiredArgsConstructor
public class StartupDataBaseInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (productRepository.count() == 0) {
            Product samsungProduct = new Product();
            samsungProduct.setId(1L);
            samsungProduct.setName("Samsung Galaxy");
            samsungProduct.setDescription("Phone for real man");
            samsungProduct.setPrice(500L);
            samsungProduct.setCategory("PHONE");
            samsungProduct.setIsAvailable(true);

            Product iphoneProduct = new Product();
            iphoneProduct.setId(2L);
            iphoneProduct.setName("Iphone 11");
            iphoneProduct.setDescription("Phone for real woman");
            iphoneProduct.setPrice(1500L);
            iphoneProduct.setIsAvailable(true);
            iphoneProduct.setCategory("PHONE");

            productRepository.save(samsungProduct);
            productRepository.save(iphoneProduct);
        }
    }

}
