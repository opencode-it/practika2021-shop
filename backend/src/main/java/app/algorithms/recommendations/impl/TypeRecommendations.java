package app.algorithms.recommendations.impl;

import app.algorithms.recommendations.Recommendations;
import app.entities.Product;
import app.entities.ProductType;

import java.util.List;

public class TypeRecommendations extends Recommendations {
    private ProductType type;

    @Override
    public List<Product> getFor(Long accountID) {
        return null;
    }
}
