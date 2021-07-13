package app.mappers.impl.complete;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.entities.ProductType;
import app.mappers.CompleteMapper;
import app.mappers.qualifiers.ProductTypeToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = FeatureGetAndGetUnitsMapper.class)
public interface ProductFilterAndGetBaseMapper extends CompleteMapper<Product,
                                                                      ProductDTO.Request.FilterByFeatures,
                                                                      ProductDTO.Response.GetBase> {

    @Mapping(target = "type", qualifiedBy = ProductTypeToString.class)
    @Override
    ProductDTO.Response.GetBase toDto(Product entity);

    @Mappings({
        @Mapping(target = "name", ignore = true),
        @Mapping(target = "desription", ignore = true),
        @Mapping(target = "price", ignore = true),
        @Mapping(target = "images", ignore = true),
        @Mapping(target = "prodStatus", ignore = true),
        @Mapping(target = "type", ignore = true)
    })
    @Override
    Product toEntity(ProductDTO.Request.FilterByFeatures dto);


}
