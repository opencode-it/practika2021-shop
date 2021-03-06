package app.repositories.impl;

import app.entities.Feature;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends LongKeyRepository<Feature> {

}
