package org.example.service;

import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductStatusCalculator productStatusCalculator;

    public ProductService(ProductRepository productRepository, ProductStatusCalculator productStatusCalculator) {
        this.productRepository = productRepository;
        this.productStatusCalculator = productStatusCalculator;
    }

    public String getActualStatus(UUID id) {
        Optional<Product> existedProduct = productRepository.findById(id);

        return existedProduct.isEmpty()
                ? "NO_SUCH_ELEMENT"
                : productStatusCalculator.calculateCurrentStatus(existedProduct.get());
    }
}
