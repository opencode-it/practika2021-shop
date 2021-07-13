package app.mappers.impl.unidirectional.request;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FeatureUpdateValueMapper extends RequestMapper<Feature, FeatureDTO.Request.UpdateValue> {

    @Mapping(source = "featureValue", target = "name")
    @Mapping(target = "unit", ignore = true)
    @Override
    Feature toEntity(FeatureDTO.Request.UpdateValue dto);
}
