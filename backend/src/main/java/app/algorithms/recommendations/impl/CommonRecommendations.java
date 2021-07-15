/*
 * Uliana
 */
package app.algorithms.recommendations.impl;

import app.algorithms.recommendations.Recommendations;
import app.entities.Feature;
import app.entities.Product;
import app.entities.Visit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonRecommendations extends Recommendations {

    private final int RecommendationsPageSize = 5;



    @Override
    public List<Product> getFor(Long accountID) {



    }

    private Map<Feature, Integer> relevantFeatures(List<Visit> visits) {
        Map<Feature, Integer> featuresRating = new HashMap<>() {
            {
                visits.forEach(v -> {
                    v.getReviewedProduct().getFeatures().forEach(f -> {
                                if (containsKey(f.getFeature())) {
                                    int newCount = get(f.getFeature()) + 1;
                                    replace(f.getFeature(), newCount);
                                }
                            }
                    );
                });
            }
        };

        return featuresRating;
    }


}
