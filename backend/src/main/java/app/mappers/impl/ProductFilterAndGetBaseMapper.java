package app.mappers.impl;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ProductFilterAndGetBaseMapper extends AbstractMapper<Product,
                                                                      ProductDTO.Request.FilterByFeatures,
                                                                      ProductDTO.Response.GetBase> {

}
