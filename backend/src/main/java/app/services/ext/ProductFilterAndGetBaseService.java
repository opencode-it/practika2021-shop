package app.services.ext;

import app.dto.impl.FeatureDTO;
import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.mappers.impl.unidirectional.request.ProductFilterMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import app.repositories.impl.ProductRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для получения базовой информации о продуктах по фильтру
 *
 * @author Александров Илья
 */
@Service
@AllArgsConstructor
public class ProductFilterAndGetBaseService extends CRUDService<Product,
                                                                ProductDTO.Request.FilterByFeatures,
                                                                ProductDTO.Response.GetBase,
                                                                ProductRepository,
                                                                ProductFilterMapper, ProductGetBaseMapper> {


    public Optional<List<ProductDTO.Response.GetBase>> findByFilter(ProductDTO.Request.FilterByFeatures featuresDTO) {
        List<FeatureDTO.Request.Get> featureDtoList = List.copyOf(featuresDTO.getRequestedFeatures());
        //List<Feature> features = featureMapper.toEntityList(featureDtoList);
        //ToDo маппинг списка DTO по фичам
        return Optional.empty();
    }
}
