package com.elleined.product_inventory_system.service;

import com.elleined.product_inventory_system.model.Product;
import com.elleined.product_inventory_system.request.ProductRequest;

import java.util.List;

public interface ProductService {
    Product save(ProductRequest productRequest);

    Product getById(Long id);
    List<Product> getAll();

    Product update(Product product,
                   ProductRequest productRequest);

    void delete(Product product);
}
