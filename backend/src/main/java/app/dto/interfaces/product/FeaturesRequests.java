package app.dto.interfaces.product;

import app.dto.impl.FeatureDTO;

import java.util.Set;

public interface FeaturesRequests {
    Set<FeatureDTO.Request.Get> getRequestedFeatures();
}
