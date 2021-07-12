package app.mappers.impl;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.AbstractMapper;

public interface FeatureUpdateAndGetUnitsMapper extends AbstractMapper<Feature,
                                                                       FeatureDTO.Request.UpdateUnits,
                                                                       FeatureDTO.Response.GetWithUnits> {

}
