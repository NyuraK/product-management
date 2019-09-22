package com.shop.controller;

import com.shop.api.swagger.controllers.ProductManagementApi;
import com.shop.api.swagger.models.ProductDTO;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController implements ProductManagementApi {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ProductDTO> get(String id) {
        return ResponseEntity.ok(service.getProduct(id));
    }

    @Override
    public ResponseEntity<Void> delete(String id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductDTO> create(ProductDTO productDTO) {
        return ResponseEntity.ok(service.createProduct(productDTO));
    }

    @Override
    public ResponseEntity<ProductDTO> update(String id, ProductDTO productDTO) {
        return ResponseEntity.ok(service.updateProduct(id, productDTO));
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }
}
