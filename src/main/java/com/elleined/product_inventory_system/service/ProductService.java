package com.elleined.product_inventory_system.service;

import com.elleined.product_inventory_system.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product save(String name,
                 String description,
                 Product.Type type,
                 int quantity,
                 BigDecimal price);

    Product getById(Long id);
    List<Product> getAll();

    Product update(Product product,
                   String name,
                   String description,
                   Product.Type type,
                   int quantity,
                   BigDecimal price);

    void delete(Product product);
}
