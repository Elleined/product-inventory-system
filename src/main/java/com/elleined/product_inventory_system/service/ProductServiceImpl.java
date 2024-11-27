package com.elleined.product_inventory_system.service;

import com.elleined.product_inventory_system.exception.ProductInventorySystemException;
import com.elleined.product_inventory_system.mapper.ProductMapper;
import com.elleined.product_inventory_system.model.Product;
import com.elleined.product_inventory_system.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(String name,
                        String description,
                        Product.Type type,
                        int quantity,
                        BigDecimal price) {

        Product product = productMapper.toEntity(name, description, type, quantity, price);
        productRepository.save(product);
        log.debug("Saving product with name of {} success", name);
        return product;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductInventorySystemException("Product with id of " + id + " doesn't exists!"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product,
                          String name,
                          String description,
                          Product.Type type,
                          int quantity,
                          BigDecimal price) {

        product.setName(name);
        product.setDescription(description);
        product.setType(type);
        product.setQuantity(quantity);
        product.setPrice(price);

        productRepository.save(product);
        log.debug("Updating product with id of {} success", product.getId());
        return product;
    }

    @Override
    public void delete(Product product) {

    }
}
