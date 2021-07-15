package app.services.ext;

import app.dto.impl.FeatureDTO;
import app.dto.impl.FilterProductDTO;
import app.dto.impl.ProductDTO;
import app.entities.Product;
import app.entities.ProductFeature;
import app.mappers.impl.unidirectional.request.ProductFilterMapper;
import app.mappers.impl.unidirectional.response.ProductGetFullMapper;
import app.repositories.impl.ProductFeatureRepository;
import app.repositories.impl.ProductRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервис для получения базовой информации о продуктах по фильтру
 *
 * @author Александров Илья
 */
@Service
@AllArgsConstructor
public class ProductFilterAndGetFullService extends CRUDService<Product,
                                                                FilterProductDTO.Request.FilterByCommonFeatures,
                                                                ProductDTO.Response.GetFull,
                                                                ProductRepository,
                                                                ProductFilterMapper,
                                                                ProductGetFullMapper> {

    @Autowired
    ProductFeatureRepository productFeatureRepository;

    public Optional<List<ProductDTO.Response.GetFull>> findByFilter(FilterProductDTO.Request.FilterByCommonFeatures featuresDTO) {
        List<Long> idList = List.copyOf(featuresDTO.getCommonFeatures())
                .stream()
                .map(FeatureDTO.Request.Get::getId)
                .collect(Collectors.toList());
        List<ProductFeature> foundFeatures = productFeatureRepository.findAllById(idList);
        List<Product> foundProducts = repository.findByFeaturesIn(foundFeatures);
        return Optional.of(responseMapper.toDtoList(foundProducts));
    }
}
