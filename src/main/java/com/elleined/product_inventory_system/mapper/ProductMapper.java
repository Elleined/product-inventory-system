package com.elleined.product_inventory_system.mapper;

import com.elleined.product_inventory_system.dto.ProductDTO;
import com.elleined.product_inventory_system.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "price", source = "price")
    })
    ProductDTO toDTO(Product product);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "type", source = "type"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "price", source = "price")
    })
    Product toEntity(String name,
                     String description,
                     Product.Type type,
                     int quantity,
                     BigDecimal price);
}
