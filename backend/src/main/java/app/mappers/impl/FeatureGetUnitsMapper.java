package app.mappers.impl;

import app.dto.impl.FeatureDTO;
import app.entities.Feature;
import app.mappers.AbstractMapper;

public interface FeatureGetUnitsMapper extends AbstractMapper<Feature,
                                                              FeatureDTO.Request.Get,
                                                              FeatureDTO.Response.GetWithUnits> {

}
