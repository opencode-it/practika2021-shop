package app.services.ext;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.impl.FeatureUpdateAndGetUnitsMapper;
import app.repositories.impl.FeatureRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeatureUpdateAndGetUnitsService extends CRUDService<Feature,
                                                                 FeatureDTO.Request.UpdateUnits,
                                                                 FeatureDTO.Response.GetWithUnits,
                                                                 FeatureRepository,
                                                                 FeatureUpdateAndGetUnitsMapper> {

}
