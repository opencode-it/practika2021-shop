package app.mappers.impl.unidirectional.response;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.CustomTypeMapper;
import app.mappers.ResponseMapper;
import app.mappers.qualifiers.UnitsToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomTypeMapper.class)
public interface FeatureGetUnitlessMapper extends ResponseMapper<Feature, FeatureDTO.Response.GetUnitless> {

    @Mapping(target = "featurePrice", ignore = true)
    @Mapping(source = "unit", target = "featureValue", qualifiedBy = UnitsToString.class)
    @Override
    FeatureDTO.Response.GetUnitless toDto(Feature entity);

}
