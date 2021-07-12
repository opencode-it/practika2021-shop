package app.mappers.impl;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.entities.ProductType;
import app.mappers.AbstractMapper;
import app.mappers.qualifiers.ProductTypeToString;
import app.mappers.qualifiers.StringToProductType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = FeatureUpdateAndGetUnitsMapper.class)
public interface ProductFilterAndGetBaseMapper extends AbstractMapper<Product,
                                                                      ProductDTO.Request.FilterByFeatures,
                                                                      ProductDTO.Response.GetBase> {

    @Mapping(target = "type", qualifiedBy = ProductTypeToString.class)
    @Override
    ProductDTO.Response.GetBase toDto(Product entity);

    @Mapping(target = "type", qualifiedBy = StringToProductType.class)
    @Override
    Product toEntity(ProductDTO.Request.FilterByFeatures dto);

    @ProductTypeToString
    static String toString(ProductType productType) {
        return productType.getName();
    }

    @StringToProductType
    static ProductType toProductType(String name) {
        return ProductType.builder()
                .name(name)
                .build();
    }
}
