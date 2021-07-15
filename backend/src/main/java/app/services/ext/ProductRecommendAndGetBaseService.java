package app.services.ext;

import app.algorithms.recommendations.impl.CommonRecommendations;
import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.impl.unidirectional.request.ProductGetRecommendedMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import app.repositories.impl.ProductRepository;
import app.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductRecommendAndGetBaseService extends CRUDService<Product,
                                                                   ProductDTO.Request.GetRecommended,
                                                                   ProductDTO.Response.GetBase,
                                                                   ProductRepository,
                                                                   ProductGetRecommendedMapper,
                                                                   ProductGetBaseMapper> {

    @Autowired
    CommonRecommendations commonRecommendations;

    public Optional<List<ProductDTO.Response.GetBase>> recommend(ProductDTO.Request.GetRecommended dto) {
        List<Product> products = commonRecommendations.getFor(dto.getAccountId());
        return Optional.of(responseMapper.toDtoList(products));
    }
}
