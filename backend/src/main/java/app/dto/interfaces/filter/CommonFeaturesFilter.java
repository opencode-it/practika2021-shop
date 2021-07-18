package app.dto.interfaces.filter;

import app.dto.impl.FeatureDTO;

import java.util.Set;

public interface CommonFeaturesFilter {
    Set<FeatureDTO.Request.Get> getCommonFeatures();
}
