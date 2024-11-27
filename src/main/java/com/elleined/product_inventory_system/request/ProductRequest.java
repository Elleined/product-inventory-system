package com.elleined.product_inventory_system.request;

import com.elleined.product_inventory_system.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Please provide product name")
    private String name;

    private String description;

    @NotNull(message = "Please provide product type")
    private Product.Type type;

    @Positive(message = "Please provide product quantity")
    private int quantity;

    @NotNull(message = "Please provide product price")
    private BigDecimal price;
}
