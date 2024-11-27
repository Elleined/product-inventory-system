package com.elleined.product_inventory_system.dto;

import com.elleined.product_inventory_system.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Product.Type type;
    private int quantity;
    private BigDecimal price;
}
