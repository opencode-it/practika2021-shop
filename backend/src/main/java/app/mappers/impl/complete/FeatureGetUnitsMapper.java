package app.mappers.impl.complete;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.CompleteMapper;
import org.mapstruct.Mapper;

@Mapper(uses = UnitsMapper.class)
public interface FeatureGetUnitsMapper extends CompleteMapper<Feature,
                                                              FeatureDTO.Request.Get,
                                                              FeatureDTO.Response.GetWithUnits> {

}
