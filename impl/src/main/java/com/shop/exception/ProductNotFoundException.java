package com.shop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductNotFoundException extends BaseProductException {

    private final String id;

    @Override
    public String getMessage() {
        return String.format("Product with id %s not found", getId());
    }
}
