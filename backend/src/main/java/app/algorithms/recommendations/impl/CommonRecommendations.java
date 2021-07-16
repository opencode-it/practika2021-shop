/*
 * Uliana
 */
package app.algorithms.recommendations.impl;

import app.algorithms.recommendations.Recommendations;
import app.algorithms.recommendations.comparators.HasFeatureComparator;
import app.entities.Product;
import app.entities.ProductFeature;
import app.entities.Visit;

import java.util.List;

/**
 * Рекомендует из общего списка продуктов
 */
public final class CommonRecommendations extends Recommendations {

    /**
     * Фиксированный размер выдаваемых рекомендаций
     */
    private final int recommendationsPageSize = 5;


    @Override
    public List<Product> getFor(Long accountID) {
        List<Visit> accountsVisits = visitsOf(accountID);
        List<Product> availableProducts = products();

        ProductFeature[] ratedFeatures = (ProductFeature[]) relevantFeatures(accountsVisits)
                                                                .keySet()
                                                                .toArray();

        for (int i = 0; i < FeatureFilterSize; i++) {
            HasFeatureComparator comparator = new HasFeatureComparator(ratedFeatures[i]);
            availableProducts.sort(comparator);
        }

        return availableProducts.subList(0, recommendationsPageSize);
    }

}
