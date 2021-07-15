/*
 * Uliana
 */
package app.algorithms.impl;

import app.algorithms.Recommendations;
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
        return null;


    }

    private Map<Feature, Integer> relevantFeatures(List<Visit> visits) {
        Map<Feature, Integer> featuresRating = new HashMap<>(){
            {
                visits.forEach(v -> {
                    //v.getReviewedProduct().get
                });
            }
        };

        return null;
    }


}
