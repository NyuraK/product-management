package com.shop.controller;

import com.shop.api.swagger.controllers.ProductManagementApi;
import com.shop.api.swagger.models.ProductDto;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}")
public class ProductController implements ProductManagementApi {
    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ProductDto> getProductById(String id) {
        return ResponseEntity.ok(service.getProduct(id));
    }

    @Override
    public ResponseEntity<Void> deleteProductById(String id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        return ResponseEntity.ok(service.createProduct(productDto));
    }

    @Override
    public ResponseEntity<ProductDto> updateProductById(String id, ProductDto productDto) {
        return ResponseEntity.ok(service.updateProduct(id, productDto));
    }

    @Override
    public ResponseEntity<List<ProductDto>> getAllProducts(List<String> list) {
        if (list.isEmpty()){
            return ResponseEntity.ok(service.getAllProducts());
        }
        else {
            return ResponseEntity.ok(service.getAllProducts(list));
        }
    }
}
