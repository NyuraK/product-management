package com.shop.model;

import com.shop.api.swagger.models.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "product-collection")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    @Field(value = "type")
    private ProductType type;

    @Field(value = "name")
    private String name;

    @Field(value = "cost")
    private Double cost;

    @Field(value = "amount")
    private Integer amount;
}
