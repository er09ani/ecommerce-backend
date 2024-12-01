package com.ecommerce.seller.service;


import com.ecommerce.seller.model.Product;
import com.ecommerce.seller.model.ProductDto;
import com.ecommerce.seller.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductDto productDto) {
        Product product = Product.ProductBuilder.builder()
                .name(productDto.name())
                .description(productDto.description())
                .price(productDto.price())
                .stock(productDto.stock())
                .build();
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
