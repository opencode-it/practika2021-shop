package app.mappers.impl.unidirectional.request;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductGetMapper extends RequestMapper<Product, ProductDTO.Request.Get> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "description", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "prodStatus", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Override
    Product toEntity(ProductDTO.Request.Get dto);
}
