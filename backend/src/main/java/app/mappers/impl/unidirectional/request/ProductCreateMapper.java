package app.mappers.impl.unidirectional.request;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.entities.ProductStatus;
import app.mappers.CustomTypeMapper;
import app.mappers.RequestMapper;
import app.mappers.qualifiers.ProductStatusByDefault;
import app.mappers.qualifiers.StringToProductType;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(uses = { CustomTypeMapper.class,
                 FeatureGetMapper.class,
                 ImageGetRequestMapper.class })
public interface ProductCreateMapper extends RequestMapper<Product, ProductDTO.Request.CreateProduct> {

    @Mapping(source = "type", target = "type", qualifiedBy = StringToProductType.class)
    @Mapping(source = "requestedFeatures", target = "features")
    @Mapping(source = "basePrice", target = "price")
    @Override
    Product toEntity(ProductDTO.Request.CreateProduct dto);

    @AfterMapping
    static void setStatusByDefault(@MappingTarget Product target) {
        target.setProdStatus(ProductStatus.WAIT_ACCEPTING);
    }
}
