package com.elleined.product_inventory_system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_product")

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false,
            updatable = false,
            unique = true
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(name = "description")
    private String description;

    @Column(
            name = "type",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(
            name = "quantity",
            nullable = false
    )
    private int quantity;

    @Column(
            name = "price",
            nullable = false
    )
    private BigDecimal price;

    public enum Type {
        FOOD,
        SPORTS,
        HOUSEHOLD,
        MUSIC,
        ELECTRONIC,
        APPLIANCE
    }
}
