package com.elleined.product_inventory_system.controller;

import com.elleined.product_inventory_system.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/v1/product-types")
@RequiredArgsConstructor
public class ProductTypeController {

    @GetMapping
    public List<Product.Type> getAll() {
        return Stream.of(Product.Type.values()).toList();
    }
}
