package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.FeatureGetMapper;
import app.mappers.impl.unidirectional.response.FeatureGetWithUnitsMapper;
import org.springframework.stereotype.Component;

@Component
public interface FeatureGetAndGetUnitsMapper extends FeatureGetMapper, FeatureGetWithUnitsMapper {

}
