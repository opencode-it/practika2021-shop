package app.algorithms.recommendations.comparators;

import app.entities.Feature;
import app.entities.Product;

import java.util.Comparator;

/**
 * Сравнивает продукты по наличию конкретной типовой фичи
 */
public final class HasTypeFeatureComparator implements Comparator<Product> {
    private final Feature filterFeature;

    public HasTypeFeatureComparator(Feature filterFeature) {
        this.filterFeature = filterFeature;
    }

    @Override
    public int compare(Product p1, Product p2) {
        if (containsTypeFeature(p1) && notContainTypeFeature(p2)) {
            return 1;
        } else if (notContainTypeFeature(p1) && containsTypeFeature(p2)) {
            return -1;
        } else {
            return 0;
        }
    }

    private boolean containsTypeFeature(Product p) {
        return p.getType().getProd_feature().contains(filterFeature);
    }

    private boolean notContainTypeFeature(Product p) {
        return !p.getType().getProd_feature().contains(filterFeature);
    }
}
