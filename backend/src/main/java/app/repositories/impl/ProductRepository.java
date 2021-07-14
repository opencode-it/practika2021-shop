package app.repositories.impl;

import app.entities.Product;
import app.entities.ProductFeature;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends LongKeyRepository<Product> {

     List<Product> findByFeatures(List<ProductFeature> features);
}
