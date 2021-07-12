package app.repositories.impl;

import app.entities.Feature;
import app.entities.Product;
import app.repositories.LongKeyRepository;

import java.util.List;

public interface ProductRepository extends LongKeyRepository<Product> {

    List<Product> findAllBy(List<Feature> features);
}
