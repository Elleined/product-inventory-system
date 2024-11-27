package com.elleined.product_inventory_system.service;

import com.elleined.product_inventory_system.mapper.ProductMapper;
import com.elleined.product_inventory_system.model.Product;
import com.elleined.product_inventory_system.repository.ProductRepository;
import com.elleined.product_inventory_system.request.ProductRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void save() {
        // Pre defined values

        // Expected Value
        String expectedName = "Name";
        String expectedDescription = "Description";
        Product.Type expectedProductType = Product.Type.ELECTRONIC;
        int expectedQuantity = 1;
        BigDecimal expectedPrice = new BigDecimal(100);

        // Mock data
        ProductRequest productRequest = ProductRequest.builder()
                .name(expectedName)
                .description(expectedDescription)
                .type(expectedProductType)
                .quantity(expectedQuantity)
                .price(expectedPrice)
                .build();

        Product expected = Product.builder()
                .name(expectedName)
                .description(expectedDescription)
                .type(expectedProductType)
                .quantity(expectedQuantity)
                .price(expectedPrice)
                .build();

        // Set up method

        // Stubbing methods
        when(productMapper.toEntity(anyString(), anyString(), any(Product.Type.class), anyInt(), any(BigDecimal.class))).thenReturn(expected);
        when(productRepository.save(any(Product.class))).thenReturn(expected);

        // Calling the method
        Product actual = productService.save(productRequest);

        // Behavior Verifications
        verify(productMapper).toEntity(anyString(), anyString(), any(Product.Type.class), anyInt(), any(BigDecimal.class));
        verify(productRepository).save(any(Product.class));

        // Assertions
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedDescription, actual.getDescription());
        assertEquals(expectedProductType, actual.getType());
        assertEquals(expectedQuantity, actual.getQuantity());
        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    void getAll() {
        // Pre defined values

        // Expected Value

        // Mock data
        List<Product> expected = List.of(
                Product.builder().build(),
                Product.builder().build()
        );

        // Set up method

        // Stubbing methods
        when(productRepository.findAll()).thenReturn(expected);

        // Calling the method
        List<Product> actual = productService.getAll();

        // Behavior Verifications

        // Assertions
        assertIterableEquals(expected, actual);
    }

    @Test
    void update() {
        // Pre defined values

        // Expected Value
        String expectedName = "Updated Name";
        String expectedDescription = "Updated Description";
        Product.Type expectedProductType = Product.Type.FOOD;
        int expectedQuantity = 2;
        BigDecimal expectedPrice = new BigDecimal(200);

        // Mock data
        ProductRequest productRequest = ProductRequest.builder()
                .name(expectedName)
                .description(expectedDescription)
                .type(expectedProductType)
                .quantity(expectedQuantity)
                .price(expectedPrice)
                .build();

        Product oldProduct = Product.builder()
                .name("Sample")
                .description("Sample")
                .type(Product.Type.ELECTRONIC)
                .quantity(1)
                .price(new BigDecimal(100))
                .build();

        // Set up method

        // Stubbing methods
        when(productRepository.save(any(Product.class))).thenReturn(oldProduct);

        // Calling the method
        Product actual = productService.update(oldProduct, productRequest);

        // Behavior Verifications
        verify(productRepository).save(any(Product.class));

        // Assertions
        assertEquals(expectedName, actual.getName());
        assertEquals(expectedDescription, actual.getDescription());
        assertEquals(expectedProductType, actual.getType());
        assertEquals(expectedQuantity, actual.getQuantity());
        assertEquals(expectedPrice, actual.getPrice());
    }

    @Test
    void delete() {
        // Pre defined values

        // Expected Value

        // Mock data
        Product productToRemove = Product.builder()
                .id(1L)
                .build();

        List<Product> products = new java.util.ArrayList<>(List.of(productToRemove));

        // Set up method

        // Stubbing methods
        doAnswer(a -> products.remove(productToRemove))
                .when(productRepository).delete(any(Product.class));

        // Calling the method
        productService.delete(productToRemove);

        // Behavior Verifications
        verify(productRepository).delete(any(Product.class));

        // Assertions
        assertTrue(products.isEmpty());
    }
}