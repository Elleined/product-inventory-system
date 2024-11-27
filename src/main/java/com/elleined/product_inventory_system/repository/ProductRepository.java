package com.elleined.product_inventory_system.repository;

import com.elleined.product_inventory_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
