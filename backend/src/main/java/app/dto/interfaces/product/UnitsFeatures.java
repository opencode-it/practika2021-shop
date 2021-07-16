package app.dto.interfaces.product;

import app.dto.impl.FeatureDTO;

import java.util.Set;

public interface UnitsFeatures {
    Set<FeatureDTO.Response.GetWithUnits> getUnitsFeatures();
}
