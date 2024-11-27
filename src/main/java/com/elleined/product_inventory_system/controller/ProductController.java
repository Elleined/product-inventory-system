package com.elleined.product_inventory_system.controller;

import com.elleined.product_inventory_system.dto.ProductDTO;
import com.elleined.product_inventory_system.mapper.ProductMapper;
import com.elleined.product_inventory_system.model.Product;
import com.elleined.product_inventory_system.request.ProductRequest;
import com.elleined.product_inventory_system.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// I have a suggestion this should be /v1/products with s based on api endpoint standards.
// So that when we hit GET request in /v1/products it's explicitly saying the return will be a list of products
// Also for POST, PUT, PATCH and DELETE

@RestController
@RequestMapping("/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ProductDTO save(@Valid @RequestBody ProductRequest request) {
        Product product = productService.save(request);
        return productMapper.toDTO(product);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        return productMapper.toDTO(product);
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return productService.getAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable("id") Long id,
                             @Valid @RequestBody ProductRequest request) {

        Product product = productService.getById(id);

        productService.update(product, request);
        return productMapper.toDTO(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        productService.delete(product);
    }
}
