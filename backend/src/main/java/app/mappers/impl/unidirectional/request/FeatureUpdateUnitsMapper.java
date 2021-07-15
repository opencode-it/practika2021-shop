package app.mappers.impl.unidirectional.request;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(uses = UnitsChangeMapper.class)
public interface FeatureUpdateUnitsMapper extends RequestMapper<Feature, FeatureDTO.Request.UpdateUnits> {

}
