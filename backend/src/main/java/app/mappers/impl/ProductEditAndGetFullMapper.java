package app.mappers.impl;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(uses = FeatureGetUnitsMapper.class)
public interface ProductEditAndGetFullMapper extends AbstractMapper<Product,
                                                                    ProductDTO.Request.EditProduct,
                                                                    ProductDTO.Response.GetFull> {

}
