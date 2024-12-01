package com.ecommerce.seller.repository;


import com.ecommerce.seller.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
