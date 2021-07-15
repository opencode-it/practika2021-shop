package app.mappers.impl.unidirectional.request;

import app.dto.impl.FilterProductDTO;
import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = FeatureGetMapper.class)
public interface ProductFilterMapper extends RequestMapper<Product, FilterProductDTO.Request.FilterByCommonFeatures> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "desription", ignore = true)
    @Mapping(target = "price", ignore = true)
    @Mapping(target = "images", ignore = true)
    @Mapping(target = "prodStatus", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(source = "commonFeatures", target = "features")
    @Override
    Product toEntity(FilterProductDTO.Request.FilterByCommonFeatures dto);
}
