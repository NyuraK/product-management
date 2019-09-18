package com.shop.repository;

import com.shop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductsRepository extends MongoRepository<Product, Integer> {
}
