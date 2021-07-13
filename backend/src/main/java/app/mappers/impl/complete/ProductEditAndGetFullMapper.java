package app.mappers.impl.complete;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.CompleteMapper;
import org.mapstruct.Mapper;

@Mapper(uses = FeatureGetAndGetUnitsMapper.class)
public interface ProductEditAndGetFullMapper extends CompleteMapper<Product,
                                                                    ProductDTO.Request.EditProduct,
                                                                    ProductDTO.Response.GetFull> {

}
