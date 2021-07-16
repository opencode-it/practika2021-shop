package app.dto.interfaces.product;

import app.dto.impl.FeatureDTO;

import java.util.Set;

public interface Features {
    Set<FeatureDTO.Response.GetUnitless> getFeatures();
}
