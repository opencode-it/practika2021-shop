package app.algorithms.recommendations.comparators;

import app.entities.Product;
import app.entities.ProductFeature;

import java.util.Comparator;

public final class HasFeatureComparator implements Comparator<Product> {
    private final ProductFeature filterFeature;

    public HasFeatureComparator(ProductFeature filterFeature) {
        this.filterFeature = filterFeature;
    }

    @Override
    public int compare(Product p1, Product p2) {
        if (p1.getFeatures().contains(filterFeature)
                && !p2.getFeatures().contains(filterFeature)) {
            return 1;
        } else if (!p1.getFeatures().contains(filterFeature)
                && p2.getFeatures().contains(filterFeature)) {
            return -1;
        } else {
            return 0;
        }
    }
}
