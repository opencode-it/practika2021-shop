/*
 * Uliana
 */
package app.algorithms.recommendations.impl;

import app.algorithms.recommendations.Recommendations;
import app.entities.Product;
import app.entities.ProductFeature;
import app.entities.Visit;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Рекомендует из общего списка продуктов
 */
public class CommonRecommendations extends Recommendations {
    private class HasFeatureComparator implements Comparator<Product> {
        private ProductFeature filterFeature;

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


    /**
     * Фиксированный размер выдаваемых рекомендаций
     */
    private final int RecommendationsPageSize = 5;

    /**
     * Ограничение количества характеристик, по
     * которым фильтруются товары
     */
    private final int FeatureFilterSize = 3;


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

        return availableProducts.subList(0, RecommendationsPageSize);
    }

    /**
     * Располагает характеристики в порядке частоты встречаемости
     * их у продуктов, чтобы определить наиболее интересующие
     * пользователя
     */
    private Map<ProductFeature, Integer> relevantFeatures(List<Visit> visits) {
        Map<ProductFeature, Integer> featuresRating = new HashMap<>() {
            {
                visits.forEach(v -> {
                    v.getReviewedProduct().getFeatures().forEach(pf -> {
                                if (containsKey(pf)) {
                                    int newCount = get(pf) + 1;
                                    replace(pf, newCount);
                                }
                            }
                    );
                });
            }
        };

        featuresRating.entrySet().stream().sorted(descendingFeatureComparator());

        return featuresRating;
    }

    /**
     * Компаратор рейтинга характеристик по возрастанию
     */
    private Comparator<Map.Entry<ProductFeature, Integer>> descendingFeatureComparator() {
        return (o1, o2) -> o2.getValue().compareTo(o1.getValue());
    }
}
