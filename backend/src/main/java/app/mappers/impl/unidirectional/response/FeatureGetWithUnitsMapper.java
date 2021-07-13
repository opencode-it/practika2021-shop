package app.mappers.impl.unidirectional.response;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = UnitsGetMapper.class)
public interface FeatureGetWithUnitsMapper extends ResponseMapper<Feature, FeatureDTO.Response.GetWithUnits> {

    @Mapping(target = "featurePrice", ignore = true)
    @Override
    FeatureDTO.Response.GetWithUnits toDto(Feature entity);
}
