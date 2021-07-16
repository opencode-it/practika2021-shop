package app.mappers.impl.unidirectional.request;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.RequestMapper;
import org.mapstruct.Mapping;

public interface ProductForAccountMapper extends RequestMapper<Product, ProductDTO.Request.GetForAccount> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "desription", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "prodStatus", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Override
    Product toEntity(ProductDTO.Request.GetForAccount dto);
}
