package com.ecommerce.seller.model;


public record ProductDto(String name, String description,
                         Double price, Integer stock) {
}

