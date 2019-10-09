package com.shop.repository;

import com.shop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {
    List<Product> findAllByIdIn(List<String> ids);
}
