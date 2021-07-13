package app.mappers.impl.unidirectional.response;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.entities.ProductFeature;
import app.mappers.CustomTypeMapper;
import app.mappers.ResponseMapper;
import app.mappers.qualifiers.ProductStatusToString;
import app.mappers.qualifiers.ProductTypeToString;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.math.BigDecimal;

@Mapper(uses = {CustomTypeMapper.class,
                ImageGetResponseMapper.class })
public interface ProductGetFullMapper extends ResponseMapper<Product, ProductDTO.Response.GetFull> {

    @Mapping(source = "price", target = "basePrice")
    @Mapping(source = "images", target = "imagesSet")
    @Mapping(source = "prodStatus", target = "status", qualifiedBy = ProductStatusToString.class)
    @Mapping(source = "type", target = "type", qualifiedBy = ProductTypeToString.class)
    @Mapping(target = "unitsFeatures", ignore = true)
    @Mapping(target = "features", ignore = true)
    @Override
    ProductDTO.Response.GetFull toDto(Product entity);

    @AfterMapping
    static void calculatePrices(Product source, @MappingTarget ProductDTO.Response.GetFull target) {
        BigDecimal additionalPrice = BigDecimal.valueOf(source.getFeatures()
                .stream()
                .mapToInt(ProductFeature::getAdditionalPrice)
                .sum());
        target.setAdditionalPrice(additionalPrice);
        target.setFullPrice(source.getPrice().add(additionalPrice));
    }
 }
