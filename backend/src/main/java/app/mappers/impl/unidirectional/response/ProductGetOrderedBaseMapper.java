package app.mappers.impl.unidirectional.response;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.CustomTypeMapper;
import app.mappers.ResponseMapper;
import app.mappers.qualifiers.ProductStatusToString;
import app.mappers.qualifiers.ProductTypeToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomTypeMapper.class)
public interface ProductGetOrderedBaseMapper extends ResponseMapper<Product, ProductDTO.Response.GetOrderedBase> {

    @Mapping(source = "type", target = "type", qualifiedBy = ProductTypeToString.class)
    @Mapping(source = "price", target = "basePrice")
    @Mapping(target = "amount", ignore = true)
    @Override
    ProductDTO.Response.GetOrderedBase toDto(Product entity);
}
