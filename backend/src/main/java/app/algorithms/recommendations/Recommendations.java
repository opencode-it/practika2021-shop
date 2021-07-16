package app.algorithms.recommendations;

import app.algorithms.recommendations.comparators.DescendingRateComparator;
import app.algorithms.recommendations.comparators.HasFeatureComparator;
import app.entities.Product;
import app.entities.ProductFeature;
import app.entities.Visit;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public abstract class Recommendations {
    /**
     * Ограничение количества характеристик, по
     * которым фильтруются товары
     */
    protected final int FeatureFilterSize = 3;

    @Autowired
    private VisitRepository visits;

    @Autowired
    private ProductRepository products;

    public abstract List<Product> getFor(Long accountID);

    /**
     * Список всех продуктов
     */
    protected List<Product> products() {
        return products.findAll();
    }

    /**
     * Все продукты, которые просмотрел данный пользователь
     */
    protected List<Visit> visitsOf(Long accountId) {
        return visits.findByAccountId(accountId).get();
    }

    /**
     * Располагает характеристики в порядке частоты встречаемости
     * их у продуктов, чтобы определить наиболее интересующие
     * пользователя
     */
    protected Map<ProductFeature, Integer> relevantFeatures(List<Visit> visits) {
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

        featuresRating.entrySet().stream().sorted(new DescendingRateComparator<ProductFeature>());

        return featuresRating;
    }

    protected List<Product> sortByCommonFeature(List<Product> products, List<Visit> visits) {
        ProductFeature[] ratedFeatures = (ProductFeature[]) relevantFeatures(visits)
                .keySet()
                .toArray();

        IntStream.range(0, FeatureFilterSize).mapToObj(i ->
                new HasFeatureComparator(ratedFeatures[i]))
                .forEach(products::sort);
        return products;
    }
}
