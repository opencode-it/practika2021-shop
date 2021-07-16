package app.algorithms.filters.impl;

import app.algorithms.filters.ProductFilter;
import app.entities.Product;
import app.entities.ProductFeature;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Отбирает из списка продукты, обладающие всемы указанными характеристиками
 */
public class FeatureProductFilter extends ProductFilter {
    private List<ProductFeature> features;

    public FeatureProductFilter(List<ProductFeature> featuresFilter) {
        features = featuresFilter;
    }

    @Override
    public List<Product> applyOn(List<Product> unfiltered) {
        return unfiltered.stream()
                .filter(this::containsSelectedFeatures)
                .collect(Collectors.toList());
    }

    private boolean containsSelectedFeatures(Product p) {
        return p.getFeatures().containsAll(features);
    }
}
