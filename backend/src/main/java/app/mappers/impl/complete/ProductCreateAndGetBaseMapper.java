package app.mappers.impl.complete;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.CompleteMapper;
import org.mapstruct.Mapper;

@Mapper(uses = FeatureGetUnitsMapper.class)
public interface ProductCreateAndGetBaseMapper extends CompleteMapper<Product,
                                                                      ProductDTO.Request.CreateProduct,
                                                                      ProductDTO.Response.GetBase> {



}
