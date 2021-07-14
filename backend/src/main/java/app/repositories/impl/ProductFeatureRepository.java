package app.repositories.impl;

import app.entities.ProductFeature;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFeatureRepository extends LongKeyRepository<ProductFeature> {

}
