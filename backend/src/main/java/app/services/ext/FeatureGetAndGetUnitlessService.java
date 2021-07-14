package app.services.ext;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.impl.unidirectional.request.FeatureGetMapper;
import app.mappers.impl.unidirectional.response.FeatureGetUnitlessMapper;
import app.repositories.impl.FeatureRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeatureGetAndGetUnitlessService extends CRUDService<Feature,
                                                                 FeatureDTO.Request.Get,
                                                                 FeatureDTO.Response.GetUnitless,
                                                                 FeatureRepository,
                                                                 FeatureGetMapper,
                                                                 FeatureGetUnitlessMapper> {

}
