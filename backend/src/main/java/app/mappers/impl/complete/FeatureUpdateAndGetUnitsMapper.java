package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.FeatureUpdateUnitsMapper;
import app.mappers.impl.unidirectional.response.FeatureGetWithUnitsMapper;
import org.springframework.stereotype.Component;

@Component
public interface FeatureUpdateAndGetUnitsMapper extends FeatureUpdateUnitsMapper, FeatureGetWithUnitsMapper {

}
