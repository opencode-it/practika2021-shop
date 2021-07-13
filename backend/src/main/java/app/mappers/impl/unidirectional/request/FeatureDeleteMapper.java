package app.mappers.impl.unidirectional.request;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FeatureDeleteMapper extends RequestMapper<Feature, FeatureDTO.Request.Delete> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "unit", ignore = true)
    @Override
    Feature toEntity(FeatureDTO.Request.Delete dto);
}
