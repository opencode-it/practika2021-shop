package app.mappers.impl.unidirectional.request;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.CustomTypeMapper;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { CustomTypeMapper.class,
                 FeatureGetMapper.class,
                 ImageGetRequestMapper.class })
public interface ProductEditMapper extends RequestMapper<Product, ProductDTO.Request.EditProduct> {

    @Mapping(target = "type", ignore = true)
    @Mapping(source = "requestedFeatures", target = "features")
    @Mapping(source = "basePrice", target = "price")
    @Mapping(target = "prodStatus", ignore = true)
    @Override
    Product toEntity(ProductDTO.Request.EditProduct dto);
}
