package app.services.ext;

import app.dto.impl.FeatureDTO;
import app.dto.impl.ProductDTO;
import app.entities.Feature;
import app.entities.Product;
import app.mappers.impl.FeatureGetUnitsMapper;
import app.mappers.impl.ProductFilterAndGetBaseMapper;
import app.repositories.impl.ProductRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
                                                                ProductFilterAndGetBaseMapper> {

    @Autowired
    FeatureGetUnitsMapper featureMapper;

    Optional<List<ProductDTO.Response.GetBase>> findBy(ProductDTO.Request.FilterByFeatures featuresDTO) {
        List<FeatureDTO.Request.Get> featureDtoList = List.copyOf(featuresDTO.getRequestedFeatures());
        List<Feature> features = featureMapper.toEntityList(featureDtoList);
        List<ProductDTO.Response.GetBase> productDtoList = mapper.toDtoList(repository.findAllBy(features));
        return Optional.of(productDtoList);
    }
}
