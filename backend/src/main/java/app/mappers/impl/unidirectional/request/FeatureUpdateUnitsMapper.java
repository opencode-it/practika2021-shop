package app.mappers.impl.unidirectional.request;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = UnitsChangeMapper.class)
public interface FeatureUpdateUnitsMapper extends RequestMapper<Feature, FeatureDTO.Request.UpdateUnits> {

    @Mapping(source = "changesUnits", target = "unit")
    @Mapping(target = "name", ignore = true)
    @Override
    Feature toEntity(FeatureDTO.Request.UpdateUnits dto);
}
