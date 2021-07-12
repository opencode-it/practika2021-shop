package app.services.ext;

import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.impl.ProductCreateAndGetBaseMapper;
import app.repositories.impl.ProductRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCreateAndGetBaseService extends CRUDService<Product,
                                                                ProductDTO.Request.CreateProduct,
                                                                ProductDTO.Response.GetBase,
                                                                ProductRepository,
                                                                ProductCreateAndGetBaseMapper> {

}
