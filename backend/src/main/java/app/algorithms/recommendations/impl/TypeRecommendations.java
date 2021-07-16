package app.algorithms.recommendations.impl;

import app.algorithms.recommendations.Recommendations;
import app.algorithms.recommendations.comparators.DescendingRateComparator;
import app.algorithms.recommendations.comparators.HasTypeFeatureComparator;
import app.entities.Feature;
import app.entities.Product;
import app.entities.ProductType;
import app.entities.Visit;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Рекомендует внутри конкретной категории продуктов
 */
public final class TypeRecommendations extends Recommendations {
    private final int TypeFeatureFilterSize = 4;
    private final int TypeRecommendationPageSize = 5;

    /**
     * Фильтр типовой характеристики, который можно поменять
     * для объекта класса TypeRecommendations
     */
    @Getter
    @Setter
    private ProductType typeFilter;

    @Override
    public List<Product> getFor(Long accountID) {
        List<Visit> accountsVisits = visitsOf(accountID)
                .stream()
                .filter(v -> v.getReviewedProduct().getType().equals(typeFilter))
                .collect(Collectors.toList());

        List<Product> availableProducts
                = products()
                .stream()
                .filter(p -> p.getType().equals(typeFilter))
                .collect(Collectors.toList());

        List<Product> sortedByTypeFeatures = sortByTypeFeatures(availableProducts, accountsVisits);
        List<Product> sortedByCommonFeatures = sortByCommonFeature(sortedByTypeFeatures, accountsVisits);

        return sortedByCommonFeatures.subList(0, TypeRecommendationPageSize);
    }

    /**
     * Располагает характеристики в порядке
     * частоты встречаемости их у продуктов
     * конкретного типа, чтобы определить
     * наиболее интересующие пользователя
     */
    protected Map<Feature, Integer> relevantTypeFeatures(List<Visit> visits) {
        Map<Feature, Integer> featuresRating = new HashMap<>() {
            {
                visits.forEach(v -> {
                    v.getReviewedProduct().getType()
                            .getProd_feature()
                            .forEach(pf -> {
                                        if (containsKey(pf)) {
                                            int newCount = get(pf) + 1;
                                            replace(pf, newCount);
                                        }
                                    }
                            );
                });
            }
        };

        featuresRating.entrySet().stream().sorted(new DescendingRateComparator<Feature>());

        return featuresRating;
    }

    private List<Product> sortByTypeFeatures(List<Product> products, List<Visit> visits) {
        Feature[] ratedTypeFeature = (Feature[]) relevantTypeFeatures(visits).keySet().toArray();
        IntStream.range(0, TypeFeatureFilterSize).mapToObj(i ->
                new HasTypeFeatureComparator(ratedTypeFeature[i]))
                .forEach(products::sort);

        return products;
    }

}
