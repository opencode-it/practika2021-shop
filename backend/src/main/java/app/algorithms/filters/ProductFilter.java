package app.algorithms.filters;

import app.entities.Product;

import java.util.List;

public abstract class ProductFilter {
    public abstract List<Product> applyOn(List<Product> unfiltered);
}
