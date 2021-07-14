package app.mappers.impl.unidirectional.response;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.CustomTypeMapper;
import app.mappers.ResponseMapper;
import app.mappers.qualifiers.ProductStatusToString;
import app.mappers.qualifiers.ProductTypeToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { CustomTypeMapper.class, ImageGetResponseMapper.class })
public interface ProductGetBaseMapper extends ResponseMapper<Product, ProductDTO.Response.GetBase> {

    @Mapping(source = "type", target = "type", qualifiedBy = ProductTypeToString.class)
    @Mapping(source = "prodStatus", target = "status", qualifiedBy = ProductStatusToString.class)
    @Mapping(source = "price", target = "basePrice")
    @Override
    ProductDTO.Response.GetBase toDto(Product entity);
}
