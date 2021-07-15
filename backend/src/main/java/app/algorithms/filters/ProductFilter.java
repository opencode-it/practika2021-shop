package app.algorithms.filters;

import app.entities.Product;

import java.util.List;

/**
 * Абстрактный класс для фильтров продуктов
 */
public abstract class ProductFilter {
    public abstract List<Product> applyOn(List<Product> unfiltered);
}
