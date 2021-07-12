package app.services.ext;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.impl.ProductEditAndGetFullMapper;
import app.repositories.impl.ProductRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductEditAndGetFullService extends CRUDService<Product,
                                                              ProductDTO.Request.EditProduct,
                                                              ProductDTO.Response.GetFull,
                                                              ProductRepository,
                                                              ProductEditAndGetFullMapper> {

}
