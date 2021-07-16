package app.dto.interfaces.filter;

import app.dto.impl.FeatureDTO;

import java.util.Set;

public interface TypeFeatureFilter {
    Set<FeatureDTO.Request.Get> getTypeFeatures();
}
