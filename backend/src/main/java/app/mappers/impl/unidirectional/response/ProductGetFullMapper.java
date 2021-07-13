package app.mappers.impl.unidirectional.response;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.ResponseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

public interface ProductGetFullMapper extends ResponseMapper<Product, ProductDTO.Response.GetFull> {

    @Override
    ProductDTO.Response.GetFull toDto(Product entity);

    @AfterMapping
    default void calculatePrices(Product source, @MappingTarget ProductDTO.Response.GetFull target) {

    }
 }
